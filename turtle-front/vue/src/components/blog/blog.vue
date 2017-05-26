<template>
  <div class="container">
    <my-header></my-header>
    <div class="blog-main">
      <h1>{{blog.title}}</h1>
      <div class="content" id="content">
        <div v-html="blog.content"></div>
      </div>
    </div>
  </div>
</template>
<style>
  .content {
    height: auto;
    border: 0 none;
    margin: 0 auto;
    max-width: 850px;
    overflow-x: hidden;
    padding-bottom: 50px;
    position: relative;
  }

  .content img {
    height: auto;
    max-width: 100%;
    vertical-align: middle;
    border: 0;
  }
</style>
<script>
  import { API } from '../../util/constants';
  import MyHeader from '../util/header.vue';

  export default {
    data() {
      return {
        blogId : '',
        blog : {
          title: '',
          content: ''
        }
      }
    },
    mounted() {
      this.init();
    },
    methods: {
      init() {
        this.blogId = this.$route.params.id;
        if(this.blogId !== parseInt(this.blogId)) {
          this.toUrl('blog-list');
        } else {
          this.$http.get(API.LOAD_BLOG_DETAIL + '?id=' + this.blogId).then(res => {
            this.blog = res.data;
          })
        }
      },
      toUrl(url) {
        this.$router.push({
          name : url
        })
      }
    },
    components: {
      "my-header": MyHeader
    }
  }
</script>
