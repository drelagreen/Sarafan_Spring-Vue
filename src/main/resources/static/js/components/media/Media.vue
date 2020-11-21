<template>
  <v-card>
    <v-flex v-if="type === 'href'" offset-sm3 sm6 xs12>
      <v-img v-if="message.linkCover" :src="message.linkCover" aspect-ratio="2.75"></v-img>
      <v-card-title>
        <div>
          <h3><a :href="message.link">{{ message.linkTitle || message.link }}</a></h3>
          <div v-if="message.linkDescription">{{ message.linkDescription }}</div>
        </div>
      </v-card-title>
    </v-flex>
    <v-flex v-if="type === 'image'" offset-sm3 sm6 xs12>
      <a :href="message.link">
        <v-img v-if="message.linkCover" :src="message.linkCover" aspect-ratio="2.75"></v-img>
        {{ message.link }}
      </a>
    </v-flex>
    <v-flex v-if="type === 'youtube'" offset-sm3 sm6 xs12>
      <you-tube :src="message.link"></you-tube>
    </v-flex>
  </v-card>
</template>

<script>
import YouTube from "components/media/YouTube.vue";

export default {
  name: "Media",
  components: {
    YouTube
  },
  props: ['message'],
  data() {
    return {
      type: 'href'
    }
  },
  beforeMount() {
    if (this.message.link.indexOf("youtu") > -1){
      this.type = 'youtube'
    } else if (this.message.link.match(/\.(jpeg|jpg|gif|png)$/) !==null) {
      this.type = 'image'
    } else {
      this.type = 'href'
    }
  }
}
</script>

<style scoped>

</style>