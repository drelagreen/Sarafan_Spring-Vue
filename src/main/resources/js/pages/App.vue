<template>
  <v-app>
    <v-app-bar app elevation="2">
      <v-btn large outlined>
        <v-toolbar-title>sarafan</v-toolbar-title>
      </v-btn>
      <v-btn
          v-if="profile"
          :disabled="$route.path === '/'"
          class="ml-1" elevation="0"
          text
          @click="showMessages"
      >
        Messages
      </v-btn>
      <v-spacer></v-spacer>
      <span v-if="profile">
        <v-btn
            :disabled="$route.path === '/'+this.$store.state.profile.id"
            elevation="0"
            @click="showProfile"
        >
          {{ profile.name }}
        </v-btn>
      </span>
      <v-btn v-if="profile" href="/logout" icon>
        <v-icon>mdi-exit-to-app</v-icon>
      </v-btn>
    </v-app-bar>
    <v-main>

      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script>
import {mapState, mapMutations} from 'vuex'
import {addHandler} from "util/ws";

export default {
  beforeMount() {
    if (!this.profile) {
      this.$router.replace('/auth')
    }
  },
  computed: mapState(['profile']),
  methods: {
    ...mapMutations([
      'updateMessageMutation',
      'addMessageMutation',
      'removeMessageMutation',
      'addCommentMutation'
    ]),
    showMessages() {
      this.$router.push('/')
    },
    showProfile() {
      this.$router.push('/user/'+this.$store.state.profile.id)
    }
  },
  created() {
    addHandler(data => {
      if (data.objectType === 'MESSAGE') {
        switch (data.eventType) {
          case 'CREATE':
            this.addMessageMutation(data.body)
            break
          case 'UPDATE':
            this.updateMessageMutation(data.body)
            break
          case 'REMOVE':
            this.removeMessageMutation(data.body)
            break
          default:
            console.error(`EventType is unknown - ${data.eventType}`)
        }
      } else if (data.objectType === 'COMMENT') {
        switch (data.eventType) {
          case 'CREATE':
            this.addCommentMutation(data.body)
            break
          // case 'UPDATE':
          //   this.updateCommentMutation(data.body)
          //   break
          // case 'REMOVE':
          //   this.removeCommentMutation(data.body)
          //   break
          default:
            console.error(`EventType is unknown - ${data.eventType}`)
        }
      } else {
        console.error(`ObjectType is unknown - ${data.objectType}`)
      }

    })
  }
}
</script>

<style>
</style>