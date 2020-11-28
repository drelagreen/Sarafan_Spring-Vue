<template>
  <v-container>
    <v-row align-content="center">
      <v-text-field
          v-model="text"
          label="Добавить комментарий"
          placeholder="Напишите что-нибудь..."
          @keyup.enter="save"
      />
      <v-btn class="mx-2 my-1 py-2" elevation="0" icon @click="save">
        <v-icon>
          mdi-plus
        </v-icon>
      </v-btn>
    </v-row>
  </v-container>
</template>

<script>
import {mapActions} from 'vuex'

export default {
  name: "CommentForm",
  props: ['messageId'],
  data() {
    return {
      text: ''
    }
  },
  methods: {
    ...mapActions(['addCommentAction']),
    async save() {
      await this.addCommentAction({
        text: this.text,
        message: {
          id: this.messageId
        }
      })
      this.text = ''
    }
  }
}
</script>

<style scoped>

</style>