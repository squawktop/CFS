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
import store from '@/store/index'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    // redirect: "/user/register",
    meta: { //该页面是否需要授权      //随便写， 也可以设置为   flag : true;
      requestAuth: true,
    }
  },

  {
    path: '/user/login',
    name: 'user_login',
    component: LoginView,
    meta: { 
      requestAuth: false,
    }
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
      requestAuth: true,
    }
  },

  {
    path: '/user/usermanage',
    name: 'user_manage',
    component: UsersManageView,
    meta: { //该页面是否需要授权
      requestAuth: true,
    }
  }
  ,
  {
    path: '/goods/manage',
    name: 'goods_manage',
    component: GoodsManageView,
    meta: { //该页面是否需要授权
      requestAuth: true,
    }
  }, {
    path: '/orders/manage',
    name: 'orders_manage',
    component: OrdersManageView,
    meta: { //该页面是否需要授权
      requestAuth: true,
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

router.beforeEach((to, from, next) => {
  if (to.meta.requestAuth && !store.state.user.is_login) {
    next({ name: "user_login" });
  } else {
    next();
  }
})

export default router
