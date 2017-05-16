<template>
  <div class="main">
    <my-header></my-header>
    <ul>
      <li v-for="blog in blogList">
        <span>{{blog.title}}</span>
        <span>{{blog.createTime}}</span>
      </li>
    </ul>
  </div>
</template>
<style scoped>
  body {
    margin: 0;
    padding: 0;
  }

  .main {
    width: 90%;
    margin: auto;
  }

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
  import {DEV_URL} from '../../util/constants';
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
        this.$http.get(DEV_URL.LOAD_BLOG_LIST)
          .then(res => {
            this.blogList = res.data;
            console.log(this.blogList);
          })
          .catch(res => {
            console.log("error happens when load blogs.");
          });
      }
    },
    components: {
      "my-header": MyHeader
    }
  }
</script>
