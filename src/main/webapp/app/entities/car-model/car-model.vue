<template>
  <div>
    <h2 id="page-heading" data-cy="CarModelHeading">
      <span id="car-model-heading">Car Models</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" @click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon> <span>Refresh list</span>
        </button>
        <router-link :to="{ name: 'CarModelCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-car-model"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span>Create a new Car Model</span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && carModels && carModels.length === 0">
      <span>No Car Models found</span>
    </div>
    <div class="table-responsive" v-if="carModels && carModels.length > 0">
      <table class="table table-striped" aria-describedby="carModels">
        <thead>
          <tr>
            <th scope="row"><span>ID</span></th>
            <th scope="row"><span>Name</span></th>
            <th scope="row"><span>Brand</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="carModel in carModels" :key="carModel.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'CarModelView', params: { carModelId: carModel.id } }">{{ carModel.id }}</router-link>
            </td>
            <td>{{ carModel.name }}</td>
            <td>
              <div v-if="carModel.brand">
                <router-link :to="{ name: 'BrandView', params: { brandId: carModel.brand.id } }">{{ carModel.brand.id }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'CarModelView', params: { carModelId: carModel.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'CarModelEdit', params: { carModelId: carModel.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline">Edit</span>
                  </button>
                </router-link>
                <b-button
                  @click="prepareRemove(carModel)"
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
        <span id="carBazaarApp.carModel.delete.question" data-cy="carModelDeleteDialogHeading">Confirm delete operation</span>
      </template>
      <div class="modal-body">
        <p id="jhi-delete-carModel-heading">Are you sure you want to delete Car Model {{ removeId }}?</p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" @click="closeDialog()">Cancel</button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-carModel"
            data-cy="entityConfirmDeleteButton"
            @click="removeCarModel()"
          >
            Delete
          </button>
        </div>
      </template>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./car-model.component.ts"></script>
