import Vue from 'vue'
import Router from 'vue-router'

import Index from '@/components/index'
import BlogList from '@/components/blog/blog-list'
import Blog from '@/components/blog/blog';
import Selfie from '@/components/blog/selfie';
import BlogMain from '@/components/blog/blog-main';
import BlogNew from '@/components/blog/blog-new';
import Garage from '@/components/blog/garage';

import Scroll from '@/components/playground/scroll';
import DinosaurRun from '@/components/playground/dinosaur-run';


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
          name: 'blog-list',
          path: 'list',
          component: BlogList
        },
        {
          name: 'selfie',
          path: 'selfie',
          component: Selfie
        },
        {
          name: 'garage',
          path: 'garage',
          component: Garage
        },
        {
          name: 'blog-new',
          path: 'new',
          component: BlogNew
        },
        {
          name: 'blog-edit',
          path: 'edit/:id',
          component: BlogNew
        },
        {
          name: 'blog-detail',
          path: 'detail/:id',
          component: Blog
        }
      ]
    },
    {
      path: '/scroll',
      name: 'scroll',
      component: Scroll
    },
    {
      path: '/dinosaur',
      name: 'dinosaur',
      component: DinosaurRun
    }
  ]
})
