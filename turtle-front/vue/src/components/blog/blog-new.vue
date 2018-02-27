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
            <input class="blog-input" v-model="verifyCode" placeholder="作者"/>
          </div>
          <div class="new-row add">
            <button @click="add()">新建</button>
            <button @click="tempSave()">暂存</button>
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
        verifyCode: "",
        blogBuffer: {

        }
      }
    },
    mounted() {
      this.init();
    },
    methods: {
      init() {
        const id = this.$route.params.id;
        if (id) {
          this.$http.get(API.LOAD_BLOG_DETAIL + '?id=' + id).then(res => {
            console.log(res);
          });

        }
      },
      add: function() {
        let body = this.content;
        if(body.length < 20) {
          alert("that's no good.");
          return;
        }
        if(!this.verifyCode.startsWith("VVV")) {
          alert("that's no good.");
          return;
        }
        this.$http.post(API.SAVE_BLOG,
          {
            title: this.title,
            summary: this.summary,
            tags: this.tags,
            content: this.content,
            verifyCode: this.verifyCode
          }).then(response => {
            console.log(response);
            let data = response.bodyText;
            console.log(data);
            if(data === POST_RESULT.SUCCESS) {
              alert("新建成功.");
            }
          });

      }
    },
    components: {
        'idea-panel': IdeaPanel
    }
  }
</script>
<style scoped>

  .verify, .add {
    width: 400px;
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
