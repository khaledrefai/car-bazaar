<template>
  <div>
    <h2 id="tracker-page-heading" data-cy="trackerPageHeading">Real-time user activities</h2>

    <div class="table-responsive">
      <table class="table table-striped" data-cy="trackerTable">
        <thead>
          <tr>
            <th>User</th>
            <th>IP Address</th>
            <th>Current page</th>
            <th>Time</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="activity of activities" :key="activity.sessionId">
            <td>{{ activity.userLogin }}</td>
            <td>{{ activity.ipAddress }}</td>
            <td>{{ activity.page }}</td>
            <td>{{ formatDate(activity.time) }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script lang="ts" src="./tracker.component.ts"></script>
