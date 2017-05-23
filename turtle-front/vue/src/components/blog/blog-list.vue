<template>
  <div class="container">
    <my-header></my-header>
    <div class="blog-main">
      <div class="left">
        <ul>
          <li v-for="blog in blogList">
            <span @click="toBlog(blog.id)">{{blog.title}}</span>
            <span>{{blog.createTime}}</span>
          </li>
        </ul>
      </div>
      <div class="right">
        <div>
          <img src="../../assets/mcree.jpeg" />
        </div>
      </div>
    </div>
  </div>
</template>
<style>
  .blog-main {
    width: 70%;
    min-width: 1000px;
    margin: auto;
  }
</style>
<style scoped>

  .blog-main {
    margin-top: 40px;
  }

  .left {
    width: 60%;
    float: left;
    margin-right: 40px;
  }

  .right {
    float: left;
  }

  ul {
    margin: 0;
    padding: 0;
    list-style: none;
  }

  ul > li {
    color: #333;
    font-size: 1.2em;
    margin-bottom: 20px;
  }

  ul > li:hover {
    text-decoration: underline;
    cursor: pointer;
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
