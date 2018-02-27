import Vue from 'vue'
import Router from 'vue-router'

import Index from '@/components/index'
import BlogList from '@/components/blog/blog-list'
import Blog from '@/components/blog/blog';
import Selfie from '@/components/blog/selfie';
import BlogMain from '@/components/blog/blog-main';
import BlogNew from '@/components/blog/blog-new';

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
      component: BlogMain,
      children: [
        {
          path: 'list',
          component: BlogList
        },
        {
          path: 'selfie',
          component: Selfie
        },
        {
          path: 'new',
          component: BlogNew
        },
        {
          path: 'edit/:id',
          component: BlogNew
        }
      ]
    },
    {
      path: '/blog/:id',
      name: 'blog',
      component: Blog
    }

  ]
})
