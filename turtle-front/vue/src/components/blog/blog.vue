<template>
  <div class="container">
    <my-header></my-header>
    <h1>{{blog.title}}</h1>
    <div>
      <p>{{blog.content}}</p>
    </div>
  </div>
</template>
<style>
  body {
    margin: 0;
    padding: 0;
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
          this.$router.push({
            name : 'blog-list'
          });
        } else {
          this.$http.get(API.LOAD_BLOG_DETAIL + '?id=' + this.blogId).then(res => {
            this.blog = res.data;
          })
        }
      }
    },
    components: {
      "my-header": MyHeader
    }
  }
</script>
