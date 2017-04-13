import Vue from 'vue'
import Router from 'vue-router'

import Index from '@/components/index'
import BlogList from '@/components/blog/blog-list'

Vue.use(Router)

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
    }
  ]
})
