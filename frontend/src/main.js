import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import InfiniteLoading from 'vue-infinite-loading';
import axios from 'axios';
import VuePlyr from 'vue-plyr'

Vue.config.productionTip = false

Vue.use(ElementUI);
Vue.use(InfiniteLoading, { /* options */ });

// The second argument is optional and sets the default config values for every player.
Vue.use(VuePlyr, {
  plyr: {
    fullscreen: { enabled: false }
  },
  emit: ['ended']
})

Vue.prototype.$axios = axios.create({
  // baseURL: "http://172.30.229.132:8080",
  baseURL: "http://localhost:8080",
});

new Vue({
  el: '#app',
  router,
  render: h => h(App)
}).$mount('#app')
