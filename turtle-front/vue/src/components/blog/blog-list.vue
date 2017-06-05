<template>
  <div class="container">
    <div class="blog-main">
      <div class="left">
        <ul>
          <li v-for="blog in blogList">
            <div class="blog-title" @click="toBlog(blog.id)">{{blog.title}}</div>
            <div class="blog-summary">
              {{blog.summary}}
            </div>
            <div class="blog-info">{{blog.createTime}}</div>
          </li>
        </ul>
      </div>
      <div class="right">
        <idea-panel></idea-panel>
      </div>
    </div>
  </div>
</template>
<style>
  .blog-main {
    width: 70%;
    min-width: 1000px;
    margin: auto;
    margin-top: 85px;
  }

  .left {
    width: 60%;
    min-width: 750px;
    float: left;
  }

  .right {
    float: left;
    margin-left: 10%;
    width: 30%;
  }
</style>
<style scoped>

  ul {
    margin: 0;
    padding: 0;
    list-style: none;
  }

  ul > li {
    color: #555;
  }

  .blog-title {
    margin-bottom: 10px;
    width: 90%;
    float: left;
    font-size: 1.5em;
    color:#222;
  }

  .blog-summary {
    width: 90%;
    float: left;
    font-size: 1em;
    margin-bottom: 20px;
  }

  .blog-info {
    line-height: 26px;
    width: 10%;
    font-size: 0.8em;
    color: #777;
    float: right;
  }

  .blog-main .blog-title:hover {
    text-decoration: underline;
    cursor: pointer;
  }

  li > div:last-child {
    float: right;
  }
</style>
<script>
  import { API } from '../../util/constants';
  import MyHeader from '../util/header.vue';
  import IdeaPanel from './idea-panel.vue';

  export default {
    data() {
      return {
        blogList: [],
        blogRaw: []
      }
    },
    mounted() {
      this.loadBlogs();
    },
    methods: {
      loadBlogs() {
        this.$http.get(API.LOAD_BLOG_LIST)
          .then(res => {
            this.blogRaw = res.data;
            for(let blog of this.blogRaw) {
              let summary = blog.summary;
              if(summary === null) {
                summary = "";
              }
              if(summary.length > 90) {
                summary = summary.substring(0, 90);
              }
              summary += "...";
              blog.summary = summary;
              this.blogList.push(blog);
            }
            console.log(res.data);
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
      "my-header": MyHeader,
      "idea-panel": IdeaPanel
    }
  }
</script>
