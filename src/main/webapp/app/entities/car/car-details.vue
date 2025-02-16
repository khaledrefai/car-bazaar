<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="car">
        <h2 class="jh-entity-heading" data-cy="carDetailsHeading"><span>Car</span> {{ car.id }}</h2>
        <dl class="row jh-entity-details">
          <dt>
            <span>Year</span>
          </dt>
          <dd>
            <span>{{ car.year }}</span>
          </dd>
          <dt>
            <span>Price</span>
          </dt>
          <dd>
            <span>{{ car.price }}</span>
          </dd>
          <dt>
            <span>Mileage</span>
          </dt>
          <dd>
            <span>{{ car.mileage }}</span>
          </dd>
          <dt>
            <span>Drivetrain</span>
          </dt>
          <dd>
            <span>{{ car.drivetrain }}</span>
          </dd>
          <dt>
            <span>Engine</span>
          </dt>
          <dd>
            <span>{{ car.engine }}</span>
          </dd>
          <dt>
            <span>Transmission</span>
          </dt>
          <dd>
            <span>{{ car.transmission }}</span>
          </dd>
          <dt>
            <span>Fuel Type</span>
          </dt>
          <dd>
            <span>{{ car.fuelType }}</span>
          </dd>
          <dt>
            <span>Exterior Color</span>
          </dt>
          <dd>
            <span>{{ car.exteriorColor }}</span>
          </dd>
          <dt>
            <span>Interior Color</span>
          </dt>
          <dd>
            <span>{{ car.interiorColor }}</span>
          </dd>
          <dt>
            <span>Vin</span>
          </dt>
          <dd>
            <span>{{ car.vin }}</span>
          </dd>
          <dt>
            <span>Location</span>
          </dt>
          <dd>
            <span>{{ car.location }}</span>
          </dd>
          <dt>
            <span>Description</span>
          </dt>
          <dd>
            <span>{{ car.description }}</span>
          </dd>
          <dt>
            <span>Published Date</span>
          </dt>
          <dd>
            <span v-if="car.publishedDate">{{ formatDateLong(car.publishedDate) }}</span>
          </dd>
          <dt>
            <span>Ad Number</span>
          </dt>
          <dd>
            <span>{{ car.adNumber }}</span>
          </dd>
          <dt>
            <span>Views</span>
          </dt>
          <dd>
            <span>{{ car.views }}</span>
          </dd>
          <dt>
            <span>Alloy Wheels</span>
          </dt>
          <dd>
            <span>{{ car.alloyWheels }}</span>
          </dd>
          <dt>
            <span>Sunroof</span>
          </dt>
          <dd>
            <span>{{ car.sunroof }}</span>
          </dd>
          <dt>
            <span>Tinted Glass</span>
          </dt>
          <dd>
            <span>{{ car.tintedGlass }}</span>
          </dd>
          <dt>
            <span>Led Headlights</span>
          </dt>
          <dd>
            <span>{{ car.ledHeadlights }}</span>
          </dd>
          <dt>
            <span>Foldable Roof</span>
          </dt>
          <dd>
            <span>{{ car.foldableRoof }}</span>
          </dd>
          <dt>
            <span>Tow Hitch</span>
          </dt>
          <dd>
            <span>{{ car.towHitch }}</span>
          </dd>
          <dt>
            <span>Adjustable Steering Wheel</span>
          </dt>
          <dd>
            <span>{{ car.adjustableSteeringWheel }}</span>
          </dd>
          <dt>
            <span>Auto Dimming Rearview</span>
          </dt>
          <dd>
            <span>{{ car.autoDimmingRearview }}</span>
          </dd>
          <dt>
            <span>Heated Front Seats</span>
          </dt>
          <dd>
            <span>{{ car.heatedFrontSeats }}</span>
          </dd>
          <dt>
            <span>Leather Seats</span>
          </dt>
          <dd>
            <span>{{ car.leatherSeats }}</span>
          </dd>
          <dt>
            <span>Blind Spot Monitor</span>
          </dt>
          <dd>
            <span>{{ car.blindSpotMonitor }}</span>
          </dd>
          <dt>
            <span>Adaptive Cruise Control</span>
          </dt>
          <dd>
            <span>{{ car.adaptiveCruiseControl }}</span>
          </dd>
          <dt>
            <span>Navigation System</span>
          </dt>
          <dd>
            <span>{{ car.navigationSystem }}</span>
          </dd>
          <dt>
            <span>Backup Camera</span>
          </dt>
          <dd>
            <span>{{ car.backupCamera }}</span>
          </dd>
          <dt>
            <span>Apple Carplay</span>
          </dt>
          <dd>
            <span>{{ car.appleCarplay }}</span>
          </dd>
          <dt>
            <span>Android Auto</span>
          </dt>
          <dd>
            <span>{{ car.androidAuto }}</span>
          </dd>
          <dt>
            <span>Premium Sound System</span>
          </dt>
          <dd>
            <span>{{ car.premiumSoundSystem }}</span>
          </dd>
          <dt>
            <span>Is First Own</span>
          </dt>
          <dd>
            <span>{{ car.isFirstOwn }}</span>
          </dd>
          <dt>
            <span>Is Acced Free</span>
          </dt>
          <dd>
            <span>{{ car.isAccedFree }}</span>
          </dd>
          <dt>
            <span>Brand</span>
          </dt>
          <dd>
            <div v-if="car.brand">
              <router-link :to="{ name: 'BrandView', params: { brandId: car.brand.id } }">{{ car.brand.id }}</router-link>
            </div>
          </dd>
          <dt>
            <span>Seller</span>
          </dt>
          <dd>
            <div v-if="car.seller">
              <router-link :to="{ name: 'SellerView', params: { sellerId: car.seller.id } }">{{ car.seller.id }}</router-link>
            </div>
          </dd>
          <dt>
            <span>Type</span>
          </dt>
          <dd>
            <div v-if="car.type">
              <router-link :to="{ name: 'CarTypeView', params: { carTypeId: car.type.id } }">{{ car.type.id }}</router-link>
            </div>
          </dd>
          <dt>
            <span>Model</span>
          </dt>
          <dd>
            <div v-if="car.model">
              <router-link :to="{ name: 'CarModelView', params: { carModelId: car.model.id } }">{{ car.model.id }}</router-link>
            </div>
          </dd>
          <dt>
            <span>City</span>
          </dt>
          <dd>
            <div v-if="car.city">
              <router-link :to="{ name: 'CityView', params: { cityId: car.city.id } }">{{ car.city.id }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" @click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span>Back</span>
        </button>
        <router-link v-if="car.id" :to="{ name: 'CarEdit', params: { carId: car.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span>Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./car-details.component.ts"></script>
