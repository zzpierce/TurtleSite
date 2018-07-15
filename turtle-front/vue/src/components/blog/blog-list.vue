<template>
  <div class="container">
    <div class="blog-main">
      <div class="left" v-loading="blogLoading">
        <div class="edit-panel">
          <div class="search">
            <el-input v-model="searchInfo" size="small" placeholder="搜索" @keyup.enter.native="search"></el-input>
          </div>
          <i class="el-icon-plus" @click="toNewBlog()"></i>
        </div>
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
              {{blog.summary_brief}}
            </div>
          </li>
        </ul>
        <div v-if="loadMore" class="load-more" @click="loadBlogs()">
          加载更多...
        </div>
      </div>
      <div class="right">
        <idea-panel></idea-panel>
        <tag-panel v-on:search-tag="searchByTag"></tag-panel>
      </div>
    </div>
  </div>
</template>
<script>
  import { POST_RESULT, API } from '../../util/constants';
  import { parse_article } from '../../util/func';
  import MyHeader from '../util/header.vue';
  import IdeaPanel from './idea-panel.vue';
  import TagPanel from './tag-panel.vue';

  export default {
    data() {
      return {
        blogList: [],
        blogRaw: [],
        blogLoading: true,
        searchInfo: "",
        currentPage: 0,
        loadMore: true
      }
    },
    mounted() {
      this.init();
    },
    methods: {
      init() {
        this.loadBlogs();
      },
      loadBlogs() {
        this.$http.get(API.LOAD_BLOG_PAGE + "?page=" + this.currentPage + "&count=10")
          .then(res => {
            if (res.status !== 200 || res.data.code !== POST_RESULT.SUCCESS) {
              this.loadFailed();
              return;
            }
            let data = res.data.data;
            this.blogRaw = data.articles;
            for(let blog of this.blogRaw) {
              blog = this.formatBlog(blog);
              this.blogList.push(blog);
            }
            this.blogLoading = false;
            this.currentPage ++;
          })
          .catch(res => {
            this.loadFailed();
            this.blogLoading = false;
          });
      },
      search() {
        let searchText = this.searchInfo;
        this.blogLoading = true;
        this.doSearchByTag(searchText);
      },
      toBlog(blogId) {
        this.$router.push({
          name : 'blog',
          params : { id : blogId }
        })
      },
      toNewBlog() {
        this.$router.push({
          name: 'blog-new'
        })
      },
      loadFailed() {
        this.$message({
          message: '网络情况不良，加载失败',
          type: 'warning'
        })
      },
      formatBlog(rawBlog) {
        let blog = parse_article(rawBlog);
        let summary = blog.summary;
        if (summary === null || summary.length < 40) {
          blog.summary_brief = summary;
        } else {
          blog.summary_brief = summary.substring(0, 40) + "...";
        }
        return blog;
      },
      searchByTag(text) {
        console.log('receive' + text);
        if (text) {
          this.loadMore = false;
          this.doSearchByTag(text);
        }
      },
      doSearchByTag(searchText) {
        this.$http.get(API.SEARCH_BLOG + "?tag=" + searchText).then(res => {
          if (res.status !== 200 || res.data.code !== POST_RESULT.SUCCESS) {
            this.loadFailed();
            return;
          }
          let data = res.data.data;
          this.blogRaw = data.articles;
          for (let blog of this.blogRaw) {
            blog = this.formatBlog(blog);
            this.blogList = this.blogRaw;
          }
          this.blogLoading = false;
          this.loadMore = false;
        }).catch(res => {
          this.loadFailed();
          this.blogLoading = false;
        });
      }
    },
    components: {
      "my-header": MyHeader,
      "idea-panel": IdeaPanel,
      "tag-panel": TagPanel
    }
  }
</script>
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

  .edit-panel {
    margin-bottom: 10px;
  }

  .edit-panel i {
    font-size: 1.5em;
    color: #6FAEB0;
    vertical-align: middle;
  }

  .edit-panel i:hover {
    cursor: pointer;
  }

  .edit-panel .search {
    display: inline-block;
  }

  .load-more {
    margin: 10px 0 20px 0;
    width: 100%;
    background-color: white;
    text-align: center;
    padding: 5px 0;
    color: #6FAEB0;
  }

  .load-more:hover {
    cursor: pointer;
  }
</style>
