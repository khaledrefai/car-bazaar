import { vitest } from 'vitest';
import { type MountingOptions, shallowMount } from '@vue/test-utils';
import sinon, { type SinonStubbedInstance } from 'sinon';
import { type RouteLocation } from 'vue-router';

import CityDetails from './city-details.vue';
import CityService from './city.service';
import AlertService from '@/shared/alert/alert.service';

type CityDetailsComponentType = InstanceType<typeof CityDetails>;

let route: Partial<RouteLocation>;
const routerGoMock = vitest.fn();

vitest.mock('vue-router', () => ({
  useRoute: () => route,
  useRouter: () => ({ go: routerGoMock }),
}));

const citySample = { id: 123 };

describe('Component Tests', () => {
  let alertService: AlertService;

  afterEach(() => {
    vitest.resetAllMocks();
  });

  describe('City Management Detail Component', () => {
    let cityServiceStub: SinonStubbedInstance<CityService>;
    let mountOptions: MountingOptions<CityDetailsComponentType>['global'];

    beforeEach(() => {
      route = {};
      cityServiceStub = sinon.createStubInstance<CityService>(CityService);

      alertService = new AlertService({
        bvToast: {
          toast: vitest.fn(),
        } as any,
      });

      mountOptions = {
        stubs: {
          'font-awesome-icon': true,
          'router-link': true,
        },
        provide: {
          alertService,
          cityService: () => cityServiceStub,
        },
      };
    });

    describe('Navigate to details', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        cityServiceStub.find.resolves(citySample);
        route = {
          params: {
            cityId: `${123}`,
          },
        };
        const wrapper = shallowMount(CityDetails, { global: mountOptions });
        const comp = wrapper.vm;
        // WHEN
        await comp.$nextTick();

        // THEN
        expect(comp.city).toMatchObject(citySample);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        cityServiceStub.find.resolves(citySample);
        const wrapper = shallowMount(CityDetails, { global: mountOptions });
        const comp = wrapper.vm;
        await comp.$nextTick();

        comp.previousState();
        await comp.$nextTick();

        expect(routerGoMock).toHaveBeenCalledWith(-1);
      });
    });
  });
});
