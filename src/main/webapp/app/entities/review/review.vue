<template>
  <div>
    <h2 id="page-heading" data-cy="ReviewHeading">
      <span id="review-heading">Reviews</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" @click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon> <span>Refresh list</span>
        </button>
        <router-link :to="{ name: 'ReviewCreate' }" custom v-slot="{ navigate }">
          <button
            @click="navigate"
            id="jh-create-entity"
            data-cy="entityCreateButton"
            class="btn btn-primary jh-create-entity create-review"
          >
            <font-awesome-icon icon="plus"></font-awesome-icon>
            <span>Create a new Review</span>
          </button>
        </router-link>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && reviews && reviews.length === 0">
      <span>No Reviews found</span>
    </div>
    <div class="table-responsive" v-if="reviews && reviews.length > 0">
      <table class="table table-striped" aria-describedby="reviews">
        <thead>
          <tr>
            <th scope="row" @click="changeOrder('id')">
              <span>ID</span> <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'id'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('createdAt')">
              <span>Created At</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'createdAt'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('revVal')">
              <span>Rev Val</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'revVal'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('revTxt')">
              <span>Rev Txt</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'revTxt'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('fromUser.id')">
              <span>From User</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'fromUser.id'"></jhi-sort-indicator>
            </th>
            <th scope="row" @click="changeOrder('toUser.id')">
              <span>To User</span>
              <jhi-sort-indicator :current-order="propOrder" :reverse="reverse" :field-name="'toUser.id'"></jhi-sort-indicator>
            </th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="review in reviews" :key="review.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'ReviewView', params: { reviewId: review.id } }">{{ review.id }}</router-link>
            </td>
            <td>{{ formatDateShort(review.createdAt) || '' }}</td>
            <td>{{ review.revVal }}</td>
            <td>{{ review.revTxt }}</td>
            <td>
              <div v-if="review.fromUser">
                <router-link :to="{ name: 'SellerView', params: { sellerId: review.fromUser.id } }">{{ review.fromUser.id }}</router-link>
              </div>
            </td>
            <td>
              <div v-if="review.toUser">
                <router-link :to="{ name: 'SellerView', params: { sellerId: review.toUser.id } }">{{ review.toUser.id }}</router-link>
              </div>
            </td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'ReviewView', params: { reviewId: review.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline">View</span>
                  </button>
                </router-link>
                <router-link :to="{ name: 'ReviewEdit', params: { reviewId: review.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-primary btn-sm edit" data-cy="entityEditButton">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                    <span class="d-none d-md-inline">Edit</span>
                  </button>
                </router-link>
                <b-button
                  @click="prepareRemove(review)"
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
        <span id="carBazaarApp.review.delete.question" data-cy="reviewDeleteDialogHeading">Confirm delete operation</span>
      </template>
      <div class="modal-body">
        <p id="jhi-delete-review-heading">Are you sure you want to delete Review {{ removeId }}?</p>
      </div>
      <template #modal-footer>
        <div>
          <button type="button" class="btn btn-secondary" @click="closeDialog()">Cancel</button>
          <button
            type="button"
            class="btn btn-primary"
            id="jhi-confirm-delete-review"
            data-cy="entityConfirmDeleteButton"
            @click="removeReview()"
          >
            Delete
          </button>
        </div>
      </template>
    </b-modal>
    <div v-show="reviews && reviews.length > 0">
      <div class="row justify-content-center">
        <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
      </div>
      <div class="row justify-content-center">
        <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage"></b-pagination>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./review.component.ts"></script>
