<template>
  <div class="container">
    <my-header></my-header>
    <div class="bm">
      <h1>{{blog.title}}</h1>
      <div class="content" id="content">
        <div v-html="blog.content"></div>
      </div>
    </div>
  </div>
</template>
<style>
  .bm {
    height: auto;
    border: 0 none;
    margin: 0 auto;
    max-width: 850px;
    overflow-x: hidden;
    padding-bottom: 50px;
    position: relative;
    color: #2C3E50;
    font-size: 16px;
    line-height: 27px;
  }

  .bm h1, .bm h2, .bm h3, .bm h4, .bm h5 {
    font-weight: 500;
  }

  .bm h3 {
    margin: 20px 0;
  }

  .bm ul, .bm ol {
    padding: 0;
    margin: 0 0 10px 25px;
  }

  .bm hr {
    border: 0;
    border-bottom: 1px dashed #cfcfcf;
    margin: 30px 0;
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
