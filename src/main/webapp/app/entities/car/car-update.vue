<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate @submit.prevent="save()">
        <h2 id="carBazaarApp.car.home.createOrEditLabel" data-cy="CarCreateUpdateHeading">Create or edit a Car</h2>
        <div>
          <div class="form-group" v-if="car.id">
            <label for="id">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="car.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-year">Year</label>
            <input
              type="number"
              class="form-control"
              name="year"
              id="car-year"
              data-cy="year"
              :class="{ valid: !v$.year.$invalid, invalid: v$.year.$invalid }"
              v-model.number="v$.year.$model"
            />
            <div v-if="v$.year.$anyDirty && v$.year.$invalid">
              <small class="form-text text-danger" v-for="error of v$.year.$errors" :key="error.$uid">{{ error.$message }}</small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-price">Price</label>
            <input
              type="number"
              class="form-control"
              name="price"
              id="car-price"
              data-cy="price"
              :class="{ valid: !v$.price.$invalid, invalid: v$.price.$invalid }"
              v-model.number="v$.price.$model"
            />
            <div v-if="v$.price.$anyDirty && v$.price.$invalid">
              <small class="form-text text-danger" v-for="error of v$.price.$errors" :key="error.$uid">{{ error.$message }}</small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-mileage">Mileage</label>
            <input
              type="number"
              class="form-control"
              name="mileage"
              id="car-mileage"
              data-cy="mileage"
              :class="{ valid: !v$.mileage.$invalid, invalid: v$.mileage.$invalid }"
              v-model.number="v$.mileage.$model"
            />
            <div v-if="v$.mileage.$anyDirty && v$.mileage.$invalid">
              <small class="form-text text-danger" v-for="error of v$.mileage.$errors" :key="error.$uid">{{ error.$message }}</small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-drivetrain">Drivetrain</label>
            <input
              type="text"
              class="form-control"
              name="drivetrain"
              id="car-drivetrain"
              data-cy="drivetrain"
              :class="{ valid: !v$.drivetrain.$invalid, invalid: v$.drivetrain.$invalid }"
              v-model="v$.drivetrain.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-engine">Engine</label>
            <input
              type="text"
              class="form-control"
              name="engine"
              id="car-engine"
              data-cy="engine"
              :class="{ valid: !v$.engine.$invalid, invalid: v$.engine.$invalid }"
              v-model="v$.engine.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-transmission">Transmission</label>
            <input
              type="text"
              class="form-control"
              name="transmission"
              id="car-transmission"
              data-cy="transmission"
              :class="{ valid: !v$.transmission.$invalid, invalid: v$.transmission.$invalid }"
              v-model="v$.transmission.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-fuelType">Fuel Type</label>
            <input
              type="text"
              class="form-control"
              name="fuelType"
              id="car-fuelType"
              data-cy="fuelType"
              :class="{ valid: !v$.fuelType.$invalid, invalid: v$.fuelType.$invalid }"
              v-model="v$.fuelType.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-exteriorColor">Exterior Color</label>
            <input
              type="text"
              class="form-control"
              name="exteriorColor"
              id="car-exteriorColor"
              data-cy="exteriorColor"
              :class="{ valid: !v$.exteriorColor.$invalid, invalid: v$.exteriorColor.$invalid }"
              v-model="v$.exteriorColor.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-interiorColor">Interior Color</label>
            <input
              type="text"
              class="form-control"
              name="interiorColor"
              id="car-interiorColor"
              data-cy="interiorColor"
              :class="{ valid: !v$.interiorColor.$invalid, invalid: v$.interiorColor.$invalid }"
              v-model="v$.interiorColor.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-vin">Vin</label>
            <input
              type="text"
              class="form-control"
              name="vin"
              id="car-vin"
              data-cy="vin"
              :class="{ valid: !v$.vin.$invalid, invalid: v$.vin.$invalid }"
              v-model="v$.vin.$model"
            />
            <div v-if="v$.vin.$anyDirty && v$.vin.$invalid">
              <small class="form-text text-danger" v-for="error of v$.vin.$errors" :key="error.$uid">{{ error.$message }}</small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-location">Location</label>
            <input
              type="text"
              class="form-control"
              name="location"
              id="car-location"
              data-cy="location"
              :class="{ valid: !v$.location.$invalid, invalid: v$.location.$invalid }"
              v-model="v$.location.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-description">Description</label>
            <input
              type="text"
              class="form-control"
              name="description"
              id="car-description"
              data-cy="description"
              :class="{ valid: !v$.description.$invalid, invalid: v$.description.$invalid }"
              v-model="v$.description.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-publishedDate">Published Date</label>
            <div class="d-flex">
              <input
                id="car-publishedDate"
                data-cy="publishedDate"
                type="datetime-local"
                class="form-control"
                name="publishedDate"
                :class="{ valid: !v$.publishedDate.$invalid, invalid: v$.publishedDate.$invalid }"
                :value="convertDateTimeFromServer(v$.publishedDate.$model)"
                @change="updateInstantField('publishedDate', $event)"
              />
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-adNumber">Ad Number</label>
            <input
              type="number"
              class="form-control"
              name="adNumber"
              id="car-adNumber"
              data-cy="adNumber"
              :class="{ valid: !v$.adNumber.$invalid, invalid: v$.adNumber.$invalid }"
              v-model.number="v$.adNumber.$model"
            />
            <div v-if="v$.adNumber.$anyDirty && v$.adNumber.$invalid">
              <small class="form-text text-danger" v-for="error of v$.adNumber.$errors" :key="error.$uid">{{ error.$message }}</small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-views">Views</label>
            <input
              type="number"
              class="form-control"
              name="views"
              id="car-views"
              data-cy="views"
              :class="{ valid: !v$.views.$invalid, invalid: v$.views.$invalid }"
              v-model.number="v$.views.$model"
            />
            <div v-if="v$.views.$anyDirty && v$.views.$invalid">
              <small class="form-text text-danger" v-for="error of v$.views.$errors" :key="error.$uid">{{ error.$message }}</small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-alloyWheels">Alloy Wheels</label>
            <input
              type="checkbox"
              class="form-check"
              name="alloyWheels"
              id="car-alloyWheels"
              data-cy="alloyWheels"
              :class="{ valid: !v$.alloyWheels.$invalid, invalid: v$.alloyWheels.$invalid }"
              v-model="v$.alloyWheels.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-sunroof">Sunroof</label>
            <input
              type="checkbox"
              class="form-check"
              name="sunroof"
              id="car-sunroof"
              data-cy="sunroof"
              :class="{ valid: !v$.sunroof.$invalid, invalid: v$.sunroof.$invalid }"
              v-model="v$.sunroof.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-tintedGlass">Tinted Glass</label>
            <input
              type="checkbox"
              class="form-check"
              name="tintedGlass"
              id="car-tintedGlass"
              data-cy="tintedGlass"
              :class="{ valid: !v$.tintedGlass.$invalid, invalid: v$.tintedGlass.$invalid }"
              v-model="v$.tintedGlass.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-ledHeadlights">Led Headlights</label>
            <input
              type="checkbox"
              class="form-check"
              name="ledHeadlights"
              id="car-ledHeadlights"
              data-cy="ledHeadlights"
              :class="{ valid: !v$.ledHeadlights.$invalid, invalid: v$.ledHeadlights.$invalid }"
              v-model="v$.ledHeadlights.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-foldableRoof">Foldable Roof</label>
            <input
              type="checkbox"
              class="form-check"
              name="foldableRoof"
              id="car-foldableRoof"
              data-cy="foldableRoof"
              :class="{ valid: !v$.foldableRoof.$invalid, invalid: v$.foldableRoof.$invalid }"
              v-model="v$.foldableRoof.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-towHitch">Tow Hitch</label>
            <input
              type="checkbox"
              class="form-check"
              name="towHitch"
              id="car-towHitch"
              data-cy="towHitch"
              :class="{ valid: !v$.towHitch.$invalid, invalid: v$.towHitch.$invalid }"
              v-model="v$.towHitch.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-adjustableSteeringWheel">Adjustable Steering Wheel</label>
            <input
              type="checkbox"
              class="form-check"
              name="adjustableSteeringWheel"
              id="car-adjustableSteeringWheel"
              data-cy="adjustableSteeringWheel"
              :class="{ valid: !v$.adjustableSteeringWheel.$invalid, invalid: v$.adjustableSteeringWheel.$invalid }"
              v-model="v$.adjustableSteeringWheel.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-autoDimmingRearview">Auto Dimming Rearview</label>
            <input
              type="checkbox"
              class="form-check"
              name="autoDimmingRearview"
              id="car-autoDimmingRearview"
              data-cy="autoDimmingRearview"
              :class="{ valid: !v$.autoDimmingRearview.$invalid, invalid: v$.autoDimmingRearview.$invalid }"
              v-model="v$.autoDimmingRearview.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-heatedFrontSeats">Heated Front Seats</label>
            <input
              type="checkbox"
              class="form-check"
              name="heatedFrontSeats"
              id="car-heatedFrontSeats"
              data-cy="heatedFrontSeats"
              :class="{ valid: !v$.heatedFrontSeats.$invalid, invalid: v$.heatedFrontSeats.$invalid }"
              v-model="v$.heatedFrontSeats.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-leatherSeats">Leather Seats</label>
            <input
              type="checkbox"
              class="form-check"
              name="leatherSeats"
              id="car-leatherSeats"
              data-cy="leatherSeats"
              :class="{ valid: !v$.leatherSeats.$invalid, invalid: v$.leatherSeats.$invalid }"
              v-model="v$.leatherSeats.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-blindSpotMonitor">Blind Spot Monitor</label>
            <input
              type="checkbox"
              class="form-check"
              name="blindSpotMonitor"
              id="car-blindSpotMonitor"
              data-cy="blindSpotMonitor"
              :class="{ valid: !v$.blindSpotMonitor.$invalid, invalid: v$.blindSpotMonitor.$invalid }"
              v-model="v$.blindSpotMonitor.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-adaptiveCruiseControl">Adaptive Cruise Control</label>
            <input
              type="checkbox"
              class="form-check"
              name="adaptiveCruiseControl"
              id="car-adaptiveCruiseControl"
              data-cy="adaptiveCruiseControl"
              :class="{ valid: !v$.adaptiveCruiseControl.$invalid, invalid: v$.adaptiveCruiseControl.$invalid }"
              v-model="v$.adaptiveCruiseControl.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-navigationSystem">Navigation System</label>
            <input
              type="checkbox"
              class="form-check"
              name="navigationSystem"
              id="car-navigationSystem"
              data-cy="navigationSystem"
              :class="{ valid: !v$.navigationSystem.$invalid, invalid: v$.navigationSystem.$invalid }"
              v-model="v$.navigationSystem.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-backupCamera">Backup Camera</label>
            <input
              type="checkbox"
              class="form-check"
              name="backupCamera"
              id="car-backupCamera"
              data-cy="backupCamera"
              :class="{ valid: !v$.backupCamera.$invalid, invalid: v$.backupCamera.$invalid }"
              v-model="v$.backupCamera.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-appleCarplay">Apple Carplay</label>
            <input
              type="checkbox"
              class="form-check"
              name="appleCarplay"
              id="car-appleCarplay"
              data-cy="appleCarplay"
              :class="{ valid: !v$.appleCarplay.$invalid, invalid: v$.appleCarplay.$invalid }"
              v-model="v$.appleCarplay.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-androidAuto">Android Auto</label>
            <input
              type="checkbox"
              class="form-check"
              name="androidAuto"
              id="car-androidAuto"
              data-cy="androidAuto"
              :class="{ valid: !v$.androidAuto.$invalid, invalid: v$.androidAuto.$invalid }"
              v-model="v$.androidAuto.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-premiumSoundSystem">Premium Sound System</label>
            <input
              type="checkbox"
              class="form-check"
              name="premiumSoundSystem"
              id="car-premiumSoundSystem"
              data-cy="premiumSoundSystem"
              :class="{ valid: !v$.premiumSoundSystem.$invalid, invalid: v$.premiumSoundSystem.$invalid }"
              v-model="v$.premiumSoundSystem.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-isFirstOwn">Is First Own</label>
            <input
              type="checkbox"
              class="form-check"
              name="isFirstOwn"
              id="car-isFirstOwn"
              data-cy="isFirstOwn"
              :class="{ valid: !v$.isFirstOwn.$invalid, invalid: v$.isFirstOwn.$invalid }"
              v-model="v$.isFirstOwn.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-isAccedFree">Is Acced Free</label>
            <input
              type="checkbox"
              class="form-check"
              name="isAccedFree"
              id="car-isAccedFree"
              data-cy="isAccedFree"
              :class="{ valid: !v$.isAccedFree.$invalid, invalid: v$.isAccedFree.$invalid }"
              v-model="v$.isAccedFree.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-brand">Brand</label>
            <select class="form-control" id="car-brand" data-cy="brand" name="brand" v-model="car.brand">
              <option :value="null"></option>
              <option
                :value="car.brand && brandOption.id === car.brand.id ? car.brand : brandOption"
                v-for="brandOption in brands"
                :key="brandOption.id"
              >
                {{ brandOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-seller">Seller</label>
            <select class="form-control" id="car-seller" data-cy="seller" name="seller" v-model="car.seller">
              <option :value="null"></option>
              <option
                :value="car.seller && sellerOption.id === car.seller.id ? car.seller : sellerOption"
                v-for="sellerOption in sellers"
                :key="sellerOption.id"
              >
                {{ sellerOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-type">Type</label>
            <select class="form-control" id="car-type" data-cy="type" name="type" v-model="car.type">
              <option :value="null"></option>
              <option
                :value="car.type && carTypeOption.id === car.type.id ? car.type : carTypeOption"
                v-for="carTypeOption in carTypes"
                :key="carTypeOption.id"
              >
                {{ carTypeOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-model">Model</label>
            <select class="form-control" id="car-model" data-cy="model" name="model" v-model="car.model">
              <option :value="null"></option>
              <option
                :value="car.model && carModelOption.id === car.model.id ? car.model : carModelOption"
                v-for="carModelOption in carModels"
                :key="carModelOption.id"
              >
                {{ carModelOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-city">City</label>
            <select class="form-control" id="car-city" data-cy="city" name="city" v-model="car.city">
              <option :value="null"></option>
              <option
                :value="car.city && cityOption.id === car.city.id ? car.city : cityOption"
                v-for="cityOption in cities"
                :key="cityOption.id"
              >
                {{ cityOption.id }}
              </option>
            </select>
          </div>
        </div>
        <div>
          <button type="button" id="cancel-save" data-cy="entityCreateCancelButton" class="btn btn-secondary" @click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span>Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="v$.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span>Save</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./car-update.component.ts"></script>
