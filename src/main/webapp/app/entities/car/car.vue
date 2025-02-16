<template>
  <div>
    <h2 id="page-heading" data-cy="CarHeading">
      <span id="car-heading">Cars</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" @click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon> <span>Refresh list</span>
        </button>
        <router-link :to="{ name: 'CarCreate' }" custom v-slot="{ navigate }">
          <button @click="navigate" id="jh-create-entity" data-cy="entityCreateButton" class="btn btn-primary jh-create-entity create-car">
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span>Create a new Car</span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && cars && cars.length === 0">
      <span>No Cars found</span>
    </div>
    <div class="table-responsive" v-if="cars && cars.length > 0">
      <table class="table table-striped" aria-describedby="cars">
        <thead>
          <tr>
            <th scope="row" @click="changeOrder('id')">
              <span>ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('year')">
              <span>Year</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'year'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('price')">
              <span>Price</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'price'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('mileage')">
              <span>Mileage</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'mileage'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('drivetrain')">
              <span>Drivetrain</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'drivetrain'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('engine')">
              <span>Engine</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'engine'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('transmission')">
              <span>Transmission</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'transmission'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('fuelType')">
              <span>Fuel Type</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fuelType'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('exteriorColor')">
              <span>Exterior Color</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'exteriorColor'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('interiorColor')">
              <span>Interior Color</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'interiorColor'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('vin')">
              <span>Vin</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'vin'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('location')">
              <span>Location</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'location'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('description')">
              <span>Description</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'description'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('publishedDate')">
              <span>Published Date</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'publishedDate'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('adNumber')">
              <span>Ad Number</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'adNumber'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('views')">
              <span>Views</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'views'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('alloyWheels')">
              <span>Alloy Wheels</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'alloyWheels'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('sunroof')">
              <span>Sunroof</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'sunroof'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('tintedGlass')">
              <span>Tinted Glass</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'tintedGlass'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('ledHeadlights')">
              <span>Led Headlights</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'ledHeadlights'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('foldableRoof')">
              <span>Foldable Roof</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'foldableRoof'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('towHitch')">
              <span>Tow Hitch</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'towHitch'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('adjustableSteeringWheel')">
              <span>Adjustable Steering Wheel</span>
              <jhi-sort-indicator
                :current-order="propOrder"
                :reverse="reverse"
                :field-name="'adjustableSteeringWheel'"
              ></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('autoDimmingRearview')">
              <span>Auto Dimming Rearview</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'autoDimmingRearview'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('heatedFrontSeats')">
              <span>Heated Front Seats</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'heatedFrontSeats'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('leatherSeats')">
              <span>Leather Seats</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'leatherSeats'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('blindSpotMonitor')">
              <span>Blind Spot Monitor</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'blindSpotMonitor'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('adaptiveCruiseControl')">
              <span>Adaptive Cruise Control</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'adaptiveCruiseControl'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('navigationSystem')">
              <span>Navigation System</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'navigationSystem'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('backupCamera')">
              <span>Backup Camera</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'backupCamera'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('appleCarplay')">
              <span>Apple Carplay</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'appleCarplay'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('androidAuto')">
              <span>Android Auto</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'androidAuto'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('premiumSoundSystem')">
              <span>Premium Sound System</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'premiumSoundSystem'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('isFirstOwn')">
              <span>Is First Own</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'isFirstOwn'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('isAccedFree')">
              <span>Is Acced Free</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'isAccedFree'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('brand.id')">
              <span>Brand</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'brand.id'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('seller.id')">
              <span>Seller</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'seller.id'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('type.id')">
              <span>Type</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'type.id'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('model.id')">
              <span>Model</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'model.id'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('city.id')">
              <span>City</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'city.id'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="car in cars" :key="car.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'CarView', params: { carId: car.id } }">{{ car.id }}</router-link>
            </td>
            <td>{{ car.year }}</td>
            <td>{{ car.price }}</td>
            <td>{{ car.mileage }}</td>
            <td>{{ car.drivetrain }}</td>
            <td>{{ car.engine }}</td>
            <td>{{ car.transmission }}</td>
            <td>{{ car.fuelType }}</td>
            <td>{{ car.exteriorColor }}</td>
            <td>{{ car.interiorColor }}</td>
            <td>{{ car.vin }}</td>
            <td>{{ car.location }}</td>
            <td>{{ car.description }}</td>
            <td>{{ formatDateShort(car.publishedDate) || '' }}</td>
            <td>{{ car.adNumber }}</td>
            <td>{{ car.views }}</td>
            <td>{{ car.alloyWheels }}</td>
            <td>{{ car.sunroof }}</td>
            <td>{{ car.tintedGlass }}</td>
            <td>{{ car.ledHeadlights }}</td>
            <td>{{ car.foldableRoof }}</td>
            <td>{{ car.towHitch }}</td>
            <td>{{ car.adjustableSteeringWheel }}</td>
            <td>{{ car.autoDimmingRearview }}</td>
            <td>{{ car.heatedFrontSeats }}</td>
            <td>{{ car.leatherSeats }}</td>
            <td>{{ car.blindSpotMonitor }}</td>
            <td>{{ car.adaptiveCruiseControl }}</td>
            <td>{{ car.navigationSystem }}</td>
            <td>{{ car.backupCamera }}</td>
            <td>{{ car.appleCarplay }}</td>
            <td>{{ car.androidAuto }}</td>
            <td>{{ car.premiumSoundSystem }}</td>
            <td>{{ car.isFirstOwn }}</td>
            <td>{{ car.isAccedFree }}</td>
            <td>
              <div v-if="car.brand">
                <router-link :to="{ name: 'BrandView', params: { brandId: car.brand.id } }">{{ car.brand.id }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="car.seller">
                <router-link :to="{ name: 'SellerView', params: { sellerId: car.seller.id } }">{{ car.seller.id }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="car.type">
                <router-link :to="{ name: 'CarTypeView', params: { carTypeId: car.type.id } }">{{ car.type.id }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="car.model">
                <router-link :to="{ name: 'CarModelView', params: { carModelId: car.model.id } }">{{ car.model.id }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="car.city">
                <router-link :to="{ name: 'CityView', params: { cityId: car.city.id } }">{{ car.city.id }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'CarView', params: { carId: car.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'CarEdit', params: { carId: car.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline">Edit</span>
                  </button>
                </router-link>
                <b-button
                  @click="prepareRemove(car)"
                  variant="danger"
                  class="btn btn-sm"
                  data-cy="entityDeleteButton"
                  v-b-modal.removeEntity
                >
                  <font-awesome-icon icon="times"></font-awesome-icon>
                  <span class="d-none d-md-inline">Delete</span>
                </b-button>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <template #modal-title>
        <span id="carBazaarApp.car.delete.question" data-cy="carDeleteDialogHeading">Confirm delete operation</span>
      </template>
      <div class="modal-body">
        <p id="jhi-delete-car-heading">Are you sure you want to delete Car {{ removeId }}?</p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" @click="closeDialog()">Cancel</button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-car"
            data-cy="entityConfirmDeleteButton"
            @click="removeCar()"
          >
            Delete
          </button>
        </div>
      </template>
    </b-modal>
    <div v-show="cars && cars.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./car.component.ts"></script>
