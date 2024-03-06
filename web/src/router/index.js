import { createRouter, createWebHistory } from 'vue-router'
// import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import RegisterView from '../views/RegisterView.vue'
import HomeView from '../views/HomeView.vue'
import UsersCenterView from '../views/UsersCenterView.vue'
import GoodsCenterView from '../views/GoodsCenterView.vue'
import NotFound from '../views/NotFoundView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    // redirect: "/user/register",
    meta: { //该页面是否需要授权
      requestAuth: false,
    }
  },

  {
    path: '/user/login',
    name: 'user_login',
    component: LoginView,
  },

  {
    path: '/user/register',
    name: 'user_register',
    component: RegisterView,
    meta: { //该页面是否需要授权
      requestAuth: false,
    }
  },
  {
    path: '/user/usercenter',
    name: 'user_center',
    component: UsersCenterView,
    meta: { //该页面是否需要授权
      requestAuth: false,
    }
  },
  {
    path: '/goods/register',
    name: 'goods_center',
    component: GoodsCenterView,
    meta: { //该页面是否需要授权
      requestAuth: false,
    }
  },

  {
    path: "/404/",
    name: "404",
    component: NotFound
  },
  {
    path: "/:catchAll(.*)",
    redirect: "/404/",  //页面重定向到404
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
