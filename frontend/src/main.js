import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import InfiniteLoading from 'vue-infinite-loading';

Vue.config.productionTip = false

Vue.use(ElementUI);
Vue.use(InfiniteLoading, { /* options */ });

new Vue({
  el: '#app',
  router,
  render: h => h(App)
}).$mount('#app')
