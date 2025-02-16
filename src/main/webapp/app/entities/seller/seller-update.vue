<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate @submit.prevent="save()">
        <h2 id="carBazaarApp.seller.home.createOrEditLabel" data-cy="SellerCreateUpdateHeading">Create or edit a Seller</h2>
        <div>
          <div class="form-group" v-if="seller.id">
            <label for="id">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="seller.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="seller-name">Name</label>
            <input
              type="text"
              class="form-control"
              name="name"
              id="seller-name"
              data-cy="name"
              :class="{ valid: !v$.name.$invalid, invalid: v$.name.$invalid }"
              v-model="v$.name.$model"
              required
            />
            <div v-if="v$.name.$anyDirty && v$.name.$invalid">
              <small class="form-text text-danger" v-for="error of v$.name.$errors" :key="error.$uid">{{ error.$message }}</small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="seller-address">Address</label>
            <input
              type="text"
              class="form-control"
              name="address"
              id="seller-address"
              data-cy="address"
              :class="{ valid: !v$.address.$invalid, invalid: v$.address.$invalid }"
              v-model="v$.address.$model"
              required
            />
            <div v-if="v$.address.$anyDirty && v$.address.$invalid">
              <small class="form-text text-danger" v-for="error of v$.address.$errors" :key="error.$uid">{{ error.$message }}</small>
            </div>
          </div>
          <div class="form-group">
            <label class="form-control-label" for="seller-mobileNo">Mobile No</label>
            <input
              type="text"
              class="form-control"
              name="mobileNo"
              id="seller-mobileNo"
              data-cy="mobileNo"
              :class="{ valid: !v$.mobileNo.$invalid, invalid: v$.mobileNo.$invalid }"
              v-model="v$.mobileNo.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="seller-whatsApp">Whats App</label>
            <input
              type="text"
              class="form-control"
              name="whatsApp"
              id="seller-whatsApp"
              data-cy="whatsApp"
              :class="{ valid: !v$.whatsApp.$invalid, invalid: v$.whatsApp.$invalid }"
              v-model="v$.whatsApp.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="seller-facebook">Facebook</label>
            <input
              type="text"
              class="form-control"
              name="facebook"
              id="seller-facebook"
              data-cy="facebook"
              :class="{ valid: !v$.facebook.$invalid, invalid: v$.facebook.$invalid }"
              v-model="v$.facebook.$model"
            />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="seller-insta">Insta</label>
            <input
              type="text"
              class="form-control"
              name="insta"
              id="seller-insta"
              data-cy="insta"
              :class="{ valid: !v$.insta.$invalid, invalid: v$.insta.$invalid }"
              v-model="v$.insta.$model"
            />
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
<script lang="ts" src="./seller-update.component.ts"></script>
