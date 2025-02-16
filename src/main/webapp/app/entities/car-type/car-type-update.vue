<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <form name="editForm" novalidate @submit.prevent="save()">
        <h2 id="carBazaarApp.carType.home.createOrEditLabel" data-cy="CarTypeCreateUpdateHeading">Create or edit a Car Type</h2>
        <div>
          <div class="form-group" v-if="carType.id">
            <label for="id">ID</label>
            <input type="text" class="form-control" id="id" name="id" v-model="carType.id" readonly />
          </div>
          <div class="form-group">
            <label class="form-control-label" for="car-type-typeName">Type Name</label>
            <input
              type="text"
              class="form-control"
              name="typeName"
              id="car-type-typeName"
              data-cy="typeName"
              :class="{ valid: !v$.typeName.$invalid, invalid: v$.typeName.$invalid }"
              v-model="v$.typeName.$model"
              required
            />
            <div v-if="v$.typeName.$anyDirty && v$.typeName.$invalid">
              <small class="form-text text-danger" v-for="error of v$.typeName.$errors" :key="error.$uid">{{ error.$message }}</small>
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
<script lang="ts" src="./car-type-update.component.ts"></script>
