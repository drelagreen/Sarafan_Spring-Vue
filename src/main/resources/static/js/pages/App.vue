<template>
  <v-app>
    <v-app-bar app elevation="2">
      <v-btn large outlined><v-toolbar-title>sarafan</v-toolbar-title></v-btn>
      <v-btn
          class="ml-1"
          elevation="0"
          text v-if="profile"
          :disabled="$route.path === '/'"
          @click="showMessages"
      >
        Messages
      </v-btn>
      <v-spacer></v-spacer>
      <span v-if="profile">
        <v-btn
            elevation="0"
            :disabled="$route.path === '/profile'"
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
import { mapState, mapMutations } from 'vuex'
import {addHandler} from "util/ws";

export default {
  computed: mapState(['profile']),
  methods: {
    ...mapMutations(['updateMessageMutation','addMessageMutation','removeMessageMutation']),
    showMessages() {
      this.$router.push('/')
    },
    showProfile() {
      this.$router.push('profile')
    }
  },
  created() {
    addHandler(data => {
      if (data.objectType === 'MESSAGE') {
        switch (data.eventType){
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

      } else {
        console.error(`ObjectType is unknown - ${data.objectType}`)
      }

    })
  },
  beforeMount() {
    if(!this.profile){
      this.$router.replace('/auth')
    }
  }
}
</script>

<style>
</style>