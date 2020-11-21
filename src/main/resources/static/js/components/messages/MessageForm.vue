<template>
  <v-row align-content="center">
    <v-text-field
        v-model="text"
        label="New message"
        placeholder="Write something"/>
    <v-btn class="mx-2 my-1 py-2" color="primary" elevation="1" @click="save">
      <v-icon>
        mdi-plus
      </v-icon>
    </v-btn>
  </v-row>
</template>

<script>
import {mapActions} from 'vuex'
export default {
  props: ['messageAttr'],
  data() {
    return {
      text: '',
      id: ''
    }
  },
  watch: {
    messageAttr: function (newVal) {
      this.text = newVal.text
      this.id = newVal.id
    }
  },
  methods: {
    ...mapActions(['updateMessageAction','addMessageAction']),
    save() {
      const message = {
        id: this.id,
        text: this.text
      };

      if (this.id) {
        this.updateMessageAction(message)
      } else {
        this.addMessageAction(message)
      }
      this.text = ''
      this.id = ''
    }
  }
}
</script>

<style>

</style>