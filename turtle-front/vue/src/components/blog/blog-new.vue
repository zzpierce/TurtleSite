<template>
  <div class="container">
    <div class="blog-main">
      <div class="left">
        <div class="new-panel">
          <div class="new-row title">
            <input class="blog-input" v-model="title" placeholder="标题"/>
          </div>
          <div class="new-row tags">
            <input class="blog-input" v-model="tags" placeholder="标签"/>
          </div>
          <div class="new-row summary">
            <textarea v-model="summary" placeholder="概要"></textarea>
          </div>
          <div class="new-row content">
            <textarea v-model="content" placeholder="内容"></textarea>
          </div>
          <div class="new-row verify">
            <input class="blog-input" v-model="creator" placeholder="作者"/>
            <input class="blog-input" v-model="verifyCode" />
          </div>
          <div class="new-row add">
            <button @click="add()">保存</button>
            <!--<button @click="tempSave()">暂存</button>-->
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
  import MyHeader from '../util/header.vue';
  import IdeaPanel from './idea-panel.vue';
  import { POST_RESULT, API } from '../../util/constants';

  export default {
    data() {
      return {
        title: "",
        summary: "",
        tags: "",
        content: "",
        creator: "",
        verifyCode: "",
        blogId: -1,
        isEdit: false
      }
    },
    mounted() {
      this.init();
    },
    methods: {
      init() {
        const id = this.$route.params.id;
        if (id) {
          this.blogId = id;
          this.isEdit = true;
          this.$http.get(API.LOAD_BLOG_DETAIL + '?id=' + id + '&format=md').then(res => {
            if (res.status !== 200 || res.data.code !== POST_RESULT.SUCCESS) {
              this.$message({
                message: '获取文章失败',
                type: 'warning'
              });
              return;
            }
            let data = res.data.data;
            this.title = data.title;
            this.summary = data.summary;
            this.tags = data.tags;
            this.content = data.content;
            this.creator = data.creator;
          }).catch(res => {
            this.$message({
              message: '网络情况不良',
              type: 'warning'
            });
          });
        }
      },
      add() {
        let body = this.content;
        if(body.length < 20) {
          this.$message({
            message: "文章可能短了一些吧.",
            type: 'warning'
          });
          return;
        }
        if(!this.verifyCode.startsWith("1")) {
          this.$message({
            message: "我看见你了.",
            type: 'warning'
          });
          return;
        }
        let blogJson = {
          title: this.title,
          summary: this.summary,
          tags: this.tags,
          content: this.content,
          verifyCode: this.verifyCode,
          creator: this.creator
        };
        if (this.isEdit) {
          blogJson['id'] = this.blogId;
        }
        this.$http.post(API.SAVE_BLOG, blogJson).then(res => {
          if (res.status !== 200 || res.data.code !== POST_RESULT.SUCCESS) {
            this.$message({
              message: '保存文章失败',
              type: 'warning'
            });
            return;
          }
          this.$message({
            message: '保存文章成功',
            type: 'success'
          });
        }).catch(res => {
          this.$message({
            message: '网络情况不良',
            type: 'warning'
          });
        });

      },
      tempSave() {
        this.$message({
          message: '暂不支持此功能',
          type: 'info'
        });
      }
    },
    components: {
        'idea-panel': IdeaPanel
    }
  }
</script>
<style scoped>

  .verify .blog-input {
    width: 20%;
    min-width: 100px;
  }

  .blog-main input {
    width: 70%;
    min-width: 300px;
    border: none;
    font-size: 14px;
    padding: 5px;
  }

  .blog-main textarea {
    padding: 5px;
    font-size: 14px;
    width: 100%;
    overflow: scroll;
    min-width: 400px;
    border: none;
  }

  .content textarea {
    min-height: 600px;
  }

  .summary textarea {
    min-height: 200px;
  }

  .new-row {
    margin-bottom: 20px;
    max-width: 1000px;
  }

  .add button {
    border: none;
    background-color: #6FAEB0;
    color: #eee;
    padding: 5px 7px;
    border-radius: 2px;
    font-size: 0.8em;
  }

  .add button:hover {
    cursor: pointer;
    color: #fff;
  }

</style>
