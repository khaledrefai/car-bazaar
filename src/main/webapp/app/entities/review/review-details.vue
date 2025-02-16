<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="review">
        <h2 class="jh-entity-heading" data-cy="reviewDetailsHeading"><span>Review</span> {{ review.id }}</h2>
        <dl class="row jh-entity-details">
          <dt>
            <span>Created At</span>
          </dt>
          <dd>
            <span v-if="review.createdAt">{{ formatDateLong(review.createdAt) }}</span>
          </dd>
          <dt>
            <span>Rev Val</span>
          </dt>
          <dd>
            <span>{{ review.revVal }}</span>
          </dd>
          <dt>
            <span>Rev Txt</span>
          </dt>
          <dd>
            <span>{{ review.revTxt }}</span>
          </dd>
          <dt>
            <span>From User</span>
          </dt>
          <dd>
            <div v-if="review.fromUser">
              <router-link :to="{ name: 'SellerView', params: { sellerId: review.fromUser.id } }">{{ review.fromUser.id }}</router-link>
            </div>
          </dd>
          <dt>
            <span>To User</span>
          </dt>
          <dd>
            <div v-if="review.toUser">
              <router-link :to="{ name: 'SellerView', params: { sellerId: review.toUser.id } }">{{ review.toUser.id }}</router-link>
            </div>
          </dd>
        </dl>
        <button type="submit" @click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span>Back</span>
        </button>
        <router-link v-if="review.id" :to="{ name: 'ReviewEdit', params: { reviewId: review.id } }" custom v-slot="{ navigate }">
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span>Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./review-details.component.ts"></script>
