import { createRouter, createWebHistory } from 'vue-router'
// import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import RegisterView from '../views/RegisterView.vue'
import HomeView from '../views/HomeView.vue'
import UsersManageView from '../views/UsersManageView.vue'
import PersonalCenterView from '../views/PersonalCenterView.vue'
import GoodsManageView from '../views/GoodsManageView.vue'
import OrdersManageView from '../views/OrdersManageView.vue'
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
    path: '/user/personalcenter',
    name: 'personal_center',
    component: PersonalCenterView,
    meta: { //该页面是否需要授权
      requestAuth: false,
    }
  },

  {
    path: '/user/useranage',
    name: 'user_manage',
    component: UsersManageView,
    meta: { //该页面是否需要授权
      requestAuth: false,
    }
  }
  ,
  {
    path: '/goods/manege',
    name: 'goods_manage',
    component: GoodsManageView,
    meta: { //该页面是否需要授权
      requestAuth: false,
    }
  }, {
    path: '/orders/manege',
    name: 'orders_manage',
    component: OrdersManageView,
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
