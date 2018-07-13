<template>
  <div class="container">
    <my-header></my-header>
    <div class="blog-main">
      <div class="left">
        <div class="bm">
          <h1>{{blog.title}}<i class="el-icon-edit" @click="editBlog()"></i></h1>
          <div class="content" id="content">
            <div v-html="blog.content"></div>
          </div>
        </div>
      </div>
      <div class="right">
        <idea-panel></idea-panel>
      </div>
    </div>
  </div>
</template>
<script>
  import { POST_RESULT, API } from '../../util/constants';
  import { parse_article } from '../../util/func';
  import MyHeader from '../util/header.vue';
  import IdeaPanel from './idea-panel.vue';

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
        this.$http.get(API.LOAD_BLOG_DETAIL + '?id=' + this.blogId + '&format=html').then(res => {
          if (res.status !== 200 || res.data.code !== POST_RESULT.SUCCESS) {
            this.$message({
              message: '加载文章失败',
              type: 'warning'
            });
            return;
          }
          let data = res.data.data;
          this.blog = parse_article(data);
          this.$nextTick(() => {
            let d = document.getElementsByTagName("code");
            hljs.configure({useBR: true});
            for (let f of d) {
              hljs.highlightBlock(f);
            }
          });
        }).catch(res => {
          this.$message({
            message: '网络情况不良',
            type: 'warning'
          });
        });
      },
      toUrl(url) {
        this.$router.push({
          name : url
        })
      },
      editBlog() {
        const blogId = this.blogId;
        this.$router.push({
          name : 'blog-edit',
          params : { blogId }
        });
      }
    },
    components: {
      "my-header": MyHeader,
      "idea-panel": IdeaPanel
    }
  }
</script>
<style scoped>
  .left {
    margin-bottom: 50px;
  }
</style>
<style>

  .bm {
    height: auto;
    overflow-x: hidden;
    color: #2C3E50;
    font-size: 16px;
    line-height: 27px;
  }

  .bm h1, .bm h2, .bm h3, .bm h4, .bm h5 {
    font-weight: 600;
  }

  .bm h3 {
    margin: 20px 0;
  }

  .bm h1>i {
    font-size: 17px;
    margin-left: 12px;
  }

  .bm h1>i:hover {
    cursor: pointer;
    color: #6FAEB0;
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

  .bm .blog-tag {
    display: inline-block;
    margin-right: 10px;
    border: 0;
    background-color: #D6DBDF;
    border-radius: 4px;
    color: #2C3E50;
    font-size: 90%;
    padding: 2px 4px;
    white-space: nowrap;
  }

  .bm .order-row span {
    margin-right: 10px;
    font-weight: 700;
  }

  .content img {
    height: auto;
    max-width: 100%;
    vertical-align: middle;
    border: 0;
  }

  .code {
    background-color: #ddd;
    padding: 5px;
    border-radius: 3px;
    border-left: 3px solid green;
    font-size: 1em;
  }

  .code-inline {
    background-color: #ddd;
    padding: 0 10px;
  }
</style>

