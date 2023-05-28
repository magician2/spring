import Vue from 'vue'
import VueRouter from 'vue-router'
import store from "@/store";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Manage',
    component: () => import('../views/Manage.vue'),
    redirect:"/login",
    children:[
      {path: 'employee', name: '社員一覧', component: () => import('../views/Employee.vue'),},
      {path: 'analyze', name: '分析', component: () => import('../views/Analyze.vue'),},
    ]
  },
  {
    path: '/login', name: 'Login', component: () => import('../views/Login.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
router.beforeEach((to,from,next)=>{
  localStorage.setItem("currentPathName",to.name)
  store.commit("setPath")
  next()
})
export default router
