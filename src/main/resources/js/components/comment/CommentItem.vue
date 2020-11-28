<template>
  <!--  <v-list>-->
  <v-list-item
  >

    <v-list-item-content>
      <user-link
          :user="comment.author"
          size="36"
      ></user-link>
      <v-list-item-title  class="mx-3">
        {{ comment.text }}
      </v-list-item-title>

    </v-list-item-content>
  </v-list-item>
  <!--  </v-list>-->
</template>

<script>
import UserLink from "components/UserLink.vue";

export default {
  name: "CommentItem",
  components: {UserLink},
  props: ['comment']
}
</script>

<style scoped>

</style>