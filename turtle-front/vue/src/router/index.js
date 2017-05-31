import Vue from 'vue'
import Router from 'vue-router'

import Index from '@/components/index'
import BlogList from '@/components/blog/blog-list'
import Blog from '@/components/blog/blog';
import Selfie from '@/components/blog/selfie';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: Index
    },
    {
      path: '/blog',
      name: 'blog-list',
      component: BlogList
    },
    {
      path: '/blog/selfie',
      name: 'selfie',
      component: Selfie
    },
    {
      path: '/blog/:id',
      name: 'blog',
      component: Blog
    }

  ]
})
