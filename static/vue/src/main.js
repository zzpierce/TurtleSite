import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter);

import App from './app.vue'
import Home from './components/home.vue'
import About from './components/about.vue'
import Blog from './components/blog.vue';
import Crash_0 from './components/Crash_0.vue'

const router = new VueRouter({
  routes: [
    { path: '/home', component: Home },
    { path: '/about', component: About },
    { path: '/blog', component: Blog },
    { path: '/**', component: Home },
    { path: '/crash_0', component: Crash_0 }
  ]
});

new Vue(Vue.util.extend({ router }, App)).$mount('#app');
