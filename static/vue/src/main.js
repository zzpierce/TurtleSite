import Vue from 'vue'
import VueRouter from 'vue-router'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-default/index.css';

import App from './app.vue';
import Home from './components/home.vue';
import About from './components/about.vue';
import Blog from './components/blog.vue';
import BlogDetail from './components/blog_detail.vue';
import Backend from './components/backend.vue';


Vue.use(VueRouter);
Vue.use(ElementUI);

const router = new VueRouter({
  routes: [
    { path: '/home', component: Home },
    { path: '/about', component: About },
    { path: '/blog', component: Blog },
    { path: '/blog/:id', component: BlogDetail },
    { path: '/backend', component: Backend },
    { path: '/**', component: Home },
  ]
});

new Vue(Vue.util.extend({ router }, App)).$mount('#app');
