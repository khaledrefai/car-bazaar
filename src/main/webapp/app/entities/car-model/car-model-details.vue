<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="carModel">
        <h2 class="jh-entity-heading" data-cy="carModelDetailsHeading"><span>Car Model</span> {{ carModel.id }}</h2>
        <dl class="row jh-entity-details">
          <dt>
            <span>Name</span>
          </dt>
          <dd>
            <span>{{ carModel.name }}</span>
          </dd>
          <dt>
            <span>Brand</span>
          </dt>
          <dd>
            <div v-if="carModel.brand">
              <router-link :to="{ name: 'BrandView', params: { brandId: carModel.brand.id } }">{{ carModel.brand.id }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" @click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span>Back</span>
        </button>
        <router-link v-if="carModel.id" :to="{ name: 'CarModelEdit', params: { carModelId: carModel.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span>Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./car-model-details.component.ts"></script>
