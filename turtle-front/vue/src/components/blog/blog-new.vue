<template>
  <div class="container">
    <div class="blog-main">
      <div class="new-row title">
        <input v-model="title" placeholder="标题"/>
      </div>
      <div class="new-row tags">
        <input v-model="tags" placeholder="标签"/>
      </div>
      <div class="new-row summary">
        <textarea v-model="summary" placeholder="概要"></textarea>
      </div>
      <div class="new-row content">
        <textarea v-model="content" placeholder="内容"></textarea>
      </div>
      <div class="new-row verify">
        <input v-model="verifyCode" placeholder="作者"/>
      </div>
      <div class="new-row add">
        <button @click="add()">ADD</button>
      </div>
    </div>
  </div>
</template>
<script>
  import MyHeader from '../util/header.vue';
  import { POST_RESULT, API } from '../../util/constants';

  export default {
    data() {
      return {
        title: "",
        summary: "",
        tags: "",
        content: "",
        verifyCode: ""
      }
    },
    methods: {
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
    }
  }
</script>
<style scoped>
  .blog-main {
    width: 70%;
    min-width: 1000px;
    margin: auto;
    margin-top: 85px;
  }

  .verify, .add {
    width: 400px;
  }

  .main input {
    width: 100%;
  }

  .blog-main textarea {
    font-size: 14px;
    width: 100%;
    overflow: scroll;
    min-width: 600px;
  }

  .content textarea {
    min-height: 600px;
  }

  .summary textarea {
    min-height: 200px;
  }

  .new-row {
    margin-top: 20px;
    margin-bottom: 20px;
    max-width: 1000px;
  }

  .title input, .tags input{
    font-size: 20px;
  }
</style>
