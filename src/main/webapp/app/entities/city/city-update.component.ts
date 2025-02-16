import { type Ref, computed, defineComponent, inject, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import CityService from './city.service';
import { useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { City, type ICity } from '@/shared/model/city.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'CityUpdate',
  setup() {
    const cityService = inject('cityService', () => new CityService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const city: Ref<ICity> = ref(new City());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'en'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

    const retrieveCity = async cityId => {
      try {
        const res = await cityService().find(cityId);
        city.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.cityId) {
      retrieveCity(route.params.cityId);
    }

    const validations = useValidation();
    const validationRules = {
      name: {
        required: validations.required('This field is required.'),
      },
    };
    const v$ = useVuelidate(validationRules, city as any);
    v$.value.$validate();

    return {
      cityService,
      alertService,
      city,
      previousState,
      isSaving,
      currentLanguage,
      v$,
    };
  },
  created(): void {},
  methods: {
    save(): void {
      this.isSaving = true;
      if (this.city.id) {
        this.cityService()
          .update(this.city)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(`A City is updated with identifier ${param.id}`);
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.cityService()
          .create(this.city)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(`A City is created with identifier ${param.id}`);
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      }
    },
  },
});
