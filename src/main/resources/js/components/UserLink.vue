<template>
  <router-link class="mb-3" :to="`/user/${user.id}`">
    <v-avatar  v-if="user && user.userpic" :size="`${size||50}px`">
      <img
          :alt="user.name"
          :src="user.userpic"
      >
    </v-avatar>

    <v-avatar v-else color="indigo" :size="`${size||50}.px`">
      <v-icon dark>
        mdi-account-circle
      </v-icon>
    </v-avatar>
    <span class="pl-3">{{userName}}</span>
  </router-link>
</template>

<script>
export default {
  name: "UserLink",
  props: ['user', 'size'],
  computed: {
    userName() {
      return  this.user ? this.user.name : 'unknown'
    }
  },
}
</script>

<style scoped>
a {
  color: #131313 !important;
  text-decoration: none
}
</style>