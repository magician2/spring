import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/globle.css'
import request from "@/utils/request";
import lang from 'element-ui/lib/locale/lang/ja'
import locale from 'element-ui/lib/locale'
import store from './store'
import { Line } from 'vue-chartjs'
import { Chart, registerables } from "chart.js";


Vue.use(ElementUI,{size: "small"},{locale});

locale.use(lang)


Vue.config.productionTip = false
Vue.prototype.request = request


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
