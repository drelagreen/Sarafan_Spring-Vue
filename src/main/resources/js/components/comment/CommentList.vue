<template>
  <v-list outlined class="ma-4">
    <v-subheader>
      Комментарии
    </v-subheader>
    <template
        v-for="(item, index) in comments"
    >
      <v-divider
          v-if="index > 0"
          :key="index"
      ></v-divider>
      <comment-item
          :key="'item' + index"
          :comment="item"
      >
      </comment-item>

    </template>
    <v-container class="px-6">
      <comment-form :message-id="messageId"></comment-form>
    </v-container>
  </v-list>
</template>

<script>
import CommentItem from "components/comment/CommentItem.vue";
import CommentForm from "components/comment/CommentForm.vue";

export default {
  name: "CommentList",
  components: {CommentForm, CommentItem},
  props: ['comments', 'messageId']
}
</script>

<style scoped>

</style>