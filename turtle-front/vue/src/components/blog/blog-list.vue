<template>
  <div class="container">
    <div class="blog-main">
      <div class="left">
        <ul class="blog-list">
          <li v-for="blog in blogList">
            <div class="blog-title">
              <div class="title-link" @click="toBlog(blog.id)">
                {{blog.title}}
              </div>
              <div class="blog-tags title-div">
                {{blog.tags}}
              </div>
              <div class="deal-time title-div">
                {{blog.createTime}}
              </div>
            </div>
            <div class="blog-summary">
              {{blog.summary}}
            </div>
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
    width: 80%;
    max-width: 1024px;
    margin: auto;
    margin-top: 85px;
  }

  .left {
    width: 65%;
    min-width: 500px;
    float: left;
  }

  .right {
    float: left;
    margin-left: 5%;
    width: 30%;
  }
</style>
<style scoped>

  .blog-list {
    margin: 0;
    padding: 0;
    list-style: none;
  }

  .blog-list > li {
    margin-bottom: 10px;
    padding: 10px;
    color: #555;
    background-color: #fff;
    box-shadow: 0 1px 3px rgba(26,26,26,.1);
    border-radius: 2px;
  }

  .title-link {
    display: inline-block;
    margin-bottom: 10px;
    font-size: 1.2em;
    font-weight: 600;
    color:#111;
  }

  .title-link:hover {
    color: #334455;
    text-decoration: underline;
    cursor: pointer;
  }

  .blog-summary {
    width: 90%;
    font-size: 1em;
    margin-bottom: 20px;
  }

  .title-div {
    display: inline-block;
    font-size: 0.6em;
    color: #777;
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
