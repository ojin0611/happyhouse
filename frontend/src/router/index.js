import Vue from 'vue';
import VueRouter from 'vue-router';
import Apt from '@/views/Apt.vue';
import Board from '@/views/Board.vue';
import MyPage from '@/views/MyPage.vue';
import Login from '@/views/Login.vue';
import Signup from '@/views/Signup.vue';
import About from '@/views/About.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/about',
    name: 'About',
    component: About,
  },
  {
    path: '/apt',
    name: 'Apt',
    component: Apt,
  },
  {
    path: '/board',
    name: 'Board',
    component: Board,
    children: [
      {
        path: "",
        name: "ArticleList",
        component: () => import("@/components/board/ArticleList.vue")
      },
      {
        path: "write",
        name: "ArticleWrite",
        component: () => import("@/components/board/ArticleWrite.vue")
      },
      {
        path: "detail",
        name: "ArticleDetail",
        component: () => import("@/components/board/ArticleDetail.vue")
      },
      {
        path: "modify/:articleno",
        name: "ArticleModify",
        component: () => import("@/components/board/ArticleModify.vue")
      }
    ]
  },
  {
    path: '/mypage',
    name: 'MyPage',
    component: MyPage,
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
  },
  {
    path: '/signup',
    name: 'Signup',
    component: Signup,
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
