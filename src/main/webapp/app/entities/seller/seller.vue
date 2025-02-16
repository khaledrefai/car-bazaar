<template>
  <div>
    <h2 id="page-heading" data-cy="SellerHeading">
      <span id="seller-heading">Sellers</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" @click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon> <span>Refresh list</span>
        </button>
        <router-link :to="{ name: 'SellerCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-seller"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span>Create a new Seller</span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && sellers && sellers.length === 0">
      <span>No Sellers found</span>
    </div>
    <div class="table-responsive" v-if="sellers && sellers.length > 0">
      <table class="table table-striped" aria-describedby="sellers">
        <thead>
          <tr>
            <th scope="row"><span>ID</span></th>
            <th scope="row"><span>Name</span></th>
            <th scope="row"><span>Address</span></th>
            <th scope="row"><span>Mobile No</span></th>
            <th scope="row"><span>Whats App</span></th>
            <th scope="row"><span>Facebook</span></th>
            <th scope="row"><span>Insta</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="seller in sellers" :key="seller.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'SellerView', params: { sellerId: seller.id } }">{{ seller.id }}</router-link>
            </td>
            <td>{{ seller.name }}</td>
            <td>{{ seller.address }}</td>
            <td>{{ seller.mobileNo }}</td>
            <td>{{ seller.whatsApp }}</td>
            <td>{{ seller.facebook }}</td>
            <td>{{ seller.insta }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'SellerView', params: { sellerId: seller.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'SellerEdit', params: { sellerId: seller.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline">Edit</span>
                  </button>
                </router-link>
                <b-button
                  @click="prepareRemove(seller)"
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
        <span id="carBazaarApp.seller.delete.question" data-cy="sellerDeleteDialogHeading">Confirm delete operation</span>
      </template>
      <div class="modal-body">
        <p id="jhi-delete-seller-heading">Are you sure you want to delete Seller {{ removeId }}?</p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" @click="closeDialog()">Cancel</button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-seller"
            data-cy="entityConfirmDeleteButton"
            @click="removeSeller()"
          >
            Delete
          </button>
        </div>
      </template>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./seller.component.ts"></script>
