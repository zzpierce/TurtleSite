<template>
  <div class="container">
    <div class="blog-main">
      <div class="content">
        <textarea v-model="content"></textarea>
      </div>
      <div class="verify">
        <input v-model="verifyCode"/>
      </div>
      <div class="add">
        <button @click="add()">ADD</button>
      </div>
    </div>
  </div>
</template>
<script>
  import MyHeader from '../util/header.vue';
  import { API } from '../../util/constants';

  export default {
    data() {
      return {
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
        this.$http.post(API.SAVE_BLOG, {content: this.content, verifyCode: this.verifyCode})
          .then(response => {
            console.log(response);
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
    margin-top: 20px;
    width: 400px;
  }

  .main input {
    width: 100%;
  }

  .main textarea {
    font-size: 14px;
    width: 100%;
    min-width: 600px;
    min-height: 600px;
    overflow: scroll;
  }
</style>
