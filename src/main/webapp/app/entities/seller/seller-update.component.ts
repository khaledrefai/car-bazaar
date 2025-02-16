import { type Ref, computed, defineComponent, inject, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { useVuelidate } from '@vuelidate/core';

import SellerService from './seller.service';
import { useValidation } from '@/shared/composables';
import { useAlertService } from '@/shared/alert/alert.service';

import { type ISeller, Seller } from '@/shared/model/seller.model';

export default defineComponent({
  compatConfig: { MODE: 3 },
  name: 'SellerUpdate',
  setup() {
    const sellerService = inject('sellerService', () => new SellerService());
    const alertService = inject('alertService', () => useAlertService(), true);

    const seller: Ref<ISeller> = ref(new Seller());
    const isSaving = ref(false);
    const currentLanguage = inject('currentLanguage', () => computed(() => navigator.language ?? 'en'), true);

    const route = useRoute();
    const router = useRouter();

    const previousState = () => router.go(-1);

    const retrieveSeller = async sellerId => {
      try {
        const res = await sellerService().find(sellerId);
        seller.value = res;
      } catch (error) {
        alertService.showHttpError(error.response);
      }
    };

    if (route.params?.sellerId) {
      retrieveSeller(route.params.sellerId);
    }

    const validations = useValidation();
    const validationRules = {
      name: {
        required: validations.required('This field is required.'),
      },
      address: {
        required: validations.required('This field is required.'),
      },
      mobileNo: {},
      whatsApp: {},
      facebook: {},
      insta: {},
    };
    const v$ = useVuelidate(validationRules, seller as any);
    v$.value.$validate();

    return {
      sellerService,
      alertService,
      seller,
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
      if (this.seller.id) {
        this.sellerService()
          .update(this.seller)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showInfo(`A Seller is updated with identifier ${param.id}`);
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      } else {
        this.sellerService()
          .create(this.seller)
          .then(param => {
            this.isSaving = false;
            this.previousState();
            this.alertService.showSuccess(`A Seller is created with identifier ${param.id}`);
          })
          .catch(error => {
            this.isSaving = false;
            this.alertService.showHttpError(error.response);
          });
      }
    },
  },
});
