<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate @submit.prevent="save()">
        <h2 id="carBazaarApp.review.home.createOrEditLabel" data-cy="ReviewCreateUpdateHeading">Create or edit a Review</h2>
        <div>
          <div class="form-group" v-if="review.id">
            <label for="id">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="review.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="review-createdAt">Created At</label>
            <div class="d-flex">
              <input
                id="review-createdAt"
                data-cy="createdAt"
                type="datetime-local"
                class="form-control"
                name="createdAt"
                :class="{ valid: !v$.createdAt.$invalid, invalid: v$.createdAt.$invalid }"
                required
                :value="convertDateTimeFromServer(v$.createdAt.$model)"
                @change="updateInstantField('createdAt', $event)"
              />
            </div>
            <div v-if="v$.createdAt.$anyDirty && v$.createdAt.$invalid">
              <small class="form-text text-danger" v-for="error of v$.createdAt.$errors" :key="error.$uid">{{ error.$message }}</small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="review-revVal">Rev Val</label>
            <input
              type="number"
              class="form-control"
              name="revVal"
              id="review-revVal"
              data-cy="revVal"
              :class="{ valid: !v$.revVal.$invalid, invalid: v$.revVal.$invalid }"
              v-model.number="v$.revVal.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="review-revTxt">Rev Txt</label>
            <input
              type="text"
              class="form-control"
              name="revTxt"
              id="review-revTxt"
              data-cy="revTxt"
              :class="{ valid: !v$.revTxt.$invalid, invalid: v$.revTxt.$invalid }"
              v-model="v$.revTxt.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="review-fromUser">From User</label>
            <select class="form-control" id="review-fromUser" data-cy="fromUser" name="fromUser" v-model="review.fromUser">
              <option :value="null"></option>
              <option
                :value="review.fromUser && sellerOption.id === review.fromUser.id ? review.fromUser : sellerOption"
                v-for="sellerOption in sellers"
                :key="sellerOption.id"
              >
                {{ sellerOption.id }}
              </option>
            </select>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="review-toUser">To User</label>
            <select class="form-control" id="review-toUser" data-cy="toUser" name="toUser" v-model="review.toUser">
              <option :value="null"></option>
              <option
                :value="review.toUser && sellerOption.id === review.toUser.id ? review.toUser : sellerOption"
                v-for="sellerOption in sellers"
                :key="sellerOption.id"
              >
                {{ sellerOption.id }}
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
<script lang="ts" src="./review-update.component.ts"></script>
