<template>
  <div class="main">
    <my-header></my-header>
    <ul>
      <li v-for="blog in blogList">
        <span @click="toBlog(blog.id)">{{blog.title}}</span>
        <span>{{blog.createTime}}</span>
      </li>
    </ul>
  </div>
</template>
<style scoped>
  ul {
    margin: 0;
    padding: 0;
    list-style: none;
  }

  ul > li {
    color: darkcyan;
    font-size: 1.2em;
  }

  li > span:last-child {
    float: right;
  }
</style>
<script>
  import { API } from '../../util/constants';
  import MyHeader from '../util/header.vue';

  export default {
    data() {
      return {
        blogList: []
      }
    },
    mounted() {
      this.loadBlogs();
    },
    methods: {
      loadBlogs() {
        this.$http.get(API.LOAD_BLOG_LIST)
          .then(res => {
            this.blogList = res.data;
          })
          .catch(res => {
            console.log("error happens when load blogs.");
          });
      },
      toBlog(blogId) {
        this.$router.push({
          name : 'blog',
          params : { id : blogId }
        })
      }
    },
    components: {
      "my-header": MyHeader
    }
  }
</script>
