<template>
  <div>
    <label>
      <span class="iconfont icon-add" @click="showNewPanel()"></span>
    </label>
    <div class="bottom-panel" v-if="addArticle.flag">
      <div class="bottom-row">
        <label>标题：</label>
        <input type="text" v-model="addArticle.title"/>
      </div>
      <div class="bottom-row">
        <label>内容：</label>
        <textarea v-model="addArticle.content"></textarea>
      </div>
      <div class="bottom-row">
        <button @click="newArticle()">YEAH</button>
      </div>
    </div>
  </div>
</template>
<script>
  export default {
    data: function() {
      return {
        addArticle: {
          flag: false,
          title: "",
          content: ""
        }
      }
    },
    methods: {
      newArticle: function() {
        var self = this;
        $.ajax({
          url: 'resources/article',
          method: 'POST',
          data: {
            title: self.addArticle.title,
            tags: '',
            content: self.addArticle.content
          }
        }).done(function(data) {
          alert(data);
        });
      },
      showNewPanel: function() {
        this.addArticle.flag = true;
      }
    }
  }
</script>
<style>
  .bottom-panel label {
    float: left;
    width: 60px;
    display: inline-block;
  }

  .bottom-panel input {
    width: 90%;
    height: 25px;
    font-size: 1em;
  }

  .bottom-panel textarea {
    float: left;
    width: 90%;
    height: 300px;
    font-size: 1em;
    margin-bottom: 20px;
  }

  .bottom-panel .bottom-row {
    margin: 20px 0;
    line-height: 25px;
    font-size: 1.2em;
  }

  .bottom-panel button {
    margin-left: 60px;
  }
</style>
