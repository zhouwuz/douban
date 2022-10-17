import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/Manage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: () => import('../views/Manage.vue'),
    redirect: "/home",
    children: [
      {path: 'home', name: 'Home', component: () => import(/* webpackChunkName: "about" */ '../views/Home.vue')},
      {path: 'user', name: 'User', component: () => import(/* webpackChunkName: "about" */ '../views/User.vue')},
      {
        path: '/lishi',
        name: 'lishi',
        component: () => import(/* webpackChunkName: "about" */ '../views/lishi.vue'),
      },
      {
        path: '/search',
        name:'search',
        component: () => import(/* webpackChunkName: "about" */ '../views/search.vue')
      },
      {
        path: '/zonglan',
        name:'zonglan',
        component: () => import(/* webpackChunkName: "about" */ '../views/zonglan.vue')

      },
      {path: '/Line', name: 'Line', component: () => import(/* webpackChunkName: "about" */ '../views/Line.vue')},
      {path: '/1', name: '1', component: () => import(/* webpackChunkName: "about" */ '../views/1.vue')},
      {path: '/2', name: '2', component: () => import(/* webpackChunkName: "about" */ '../views/2.vue')},
      {path: '/3', name: '3', component: () => import(/* webpackChunkName: "about" */ '../views/3.vue')},
      {path: '/4', name: '4', component: () => import(/* webpackChunkName: "about" */ '../views/4.vue')},
      {path: '/6', name: '6', component: () => import(/* webpackChunkName: "about" */ '../views/6.vue')},
      {path: '/7', name: '7', component: () => import(/* webpackChunkName: "about" */ '../views/7.vue')},
      {path: '/sc', name: 'sc', component: () => import(/* webpackChunkName: "about" */ '../views/sc.vue')},
      {path: '/Sector', name: 'Sector', component: () => import(/* webpackChunkName: "about" */ '../views/Sector.vue')},
      {
        path: '/mock',
        name: 'mock',
        component: () => import(/* webpackChunkName: "about" */ '../views/mock.vue')
      }
    ]
  },


  {
    path: '/login',
    name: 'Login',
    component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue'),
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import(/* webpackChunkName: "about" */ '../views/Register.vue')
  },


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
