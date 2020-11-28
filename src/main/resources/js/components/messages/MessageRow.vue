<template>
  <v-card class="my-2">
    <v-card-text>
      <user-link
          :user="message.author"
          size="48"
      ></user-link>
      <v-divider class="mt-2"></v-divider>
      <v-flex class="my-4 mx-4 font-weight-medium text-body-1">
        <strong>{{ message.text }}</strong>
      </v-flex>
    </v-card-text>
    <media v-if="message.link" :message="message"></media>
    <v-card-actions class="ml-2">
      <v-btn color="primary" elevation="0" outlined small @click="edit">Edit</v-btn>
      <v-btn color="error" outlined small @click="del">
        <v-icon>mdi-delete</v-icon>
      </v-btn>
    </v-card-actions>
    <comment-list
        :comments="message.comments"
        :message-id="message.id"
    ></comment-list>
  </v-card>
</template>

<script>
import {mapActions} from 'vuex'
import Media from "components/media/Media.vue";
import CommentList from "components/comment/CommentList.vue";
import UserLink from "components/UserLink.vue";

export default {
  props: ['message', 'editMessage'],
  components: {UserLink, CommentList, Media},

  methods: {
    ...mapActions(['removeMessageAction']),
    edit() {
      this.editMessage(this.message)
    },
    del() {
      this.removeMessageAction(this.message)
    }
  }
}
</script>

<style>

</style>