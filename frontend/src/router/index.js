import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/watch',
    name: 'Watch',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Watch.vue')
  }, 
  {
    path: '/newapp',
    name: 'new_App',
    component: () => import(/* webpackChunkName: "about" */ '../views/new_App.vue')
  },
]

const router = new VueRouter({
  routes
})

export default router
