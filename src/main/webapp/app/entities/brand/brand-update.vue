<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate @submit.prevent="save()">
        <h2 id="carBazaarApp.brand.home.createOrEditLabel" data-cy="BrandCreateUpdateHeading">Create or edit a Brand</h2>
        <div>
          <div class="form-group" v-if="brand.id">
            <label for="id">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="brand.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="brand-name">Name</label>
            <input
              type="text"
              class="form-control"
              name="name"
              id="brand-name"
              data-cy="name"
              :class="{ valid: !v$.name.$invalid, invalid: v$.name.$invalid }"
              v-model="v$.name.$model"
              required
            />
            <div v-if="v$.name.$anyDirty && v$.name.$invalid">
              <small class="form-text text-danger" v-for="error of v$.name.$errors" :key="error.$uid">{{ error.$message }}</small>
            </div>
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
<script lang="ts" src="./brand-update.component.ts"></script>
