import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter);

import App from './App.vue'
import Home from './components/Home.vue'
import About from './components/About.vue'
import Crash_0 from './components/Crash_0.vue'

const router = new VueRouter({
  mode: 'history',
  base: __dirname,
  routes: [
    { path: '/', component: Home},
    { path: '/about', component: About },
    { path: '/crash_0', component: Crash_0}
  ]
});

new Vue(Vue.util.extend({ router }, App)).$mount('#app');



// import Test from './Test.vue'
//
// new Vue({
//   el: 'body',
//   components: {
//     Test: Test
//   }
// });
