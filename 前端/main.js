import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import "./mock/index"



import 'element-ui/lib/theme-chalk/index.css';
import './assets/gloable.css'
import request from "@/utils/request";
// 引入echarts
import *as echarts from 'echarts'
// import echarts from 'echarts'
Vue.prototype.$echarts = echarts

require('./mock')



Vue.config.productionTip = false

Vue.use(ElementUI, { size: "mini" });

Vue.prototype.request=request;

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')



