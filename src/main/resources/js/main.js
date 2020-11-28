import Vue from 'vue'
import Vuetify from "vuetify"
import '@babel/polyfill'
import 'api/resource'
import router from 'router/router'
import App from 'pages/App.vue'
import { connect } from './util/ws'
import 'vuetify/dist/vuetify.min.css'
import store from "store/store"

if (profile) {
    connect()
}

Vue.use(Vuetify)

new Vue({
    el: '#app',
    store: store,
    vuetify: new Vuetify(),
    router: router,
    render: a => a(App)
})

