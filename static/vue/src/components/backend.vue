<template>
  <div class="edit">
    <div class="left-panel">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>博客</el-breadcrumb-item>
        <el-breadcrumb-item>新建文章</el-breadcrumb-item>
      </el-breadcrumb>
      <div class="edit-row">
        <el-input placeholder="请输入题目" v-model="article.title">
          <template slot="prepend">文章标题</template>
        </el-input>
      </div>
      <div class="edit-row tag-row">
        <el-tag
          :key="tag"
          v-for="tag in article.tags"
          :closable="true"
          :close-transition="false"
          @close="handleClose(tag)"
        >
          {{tag}}
        </el-tag>
        <el-input
          class="input-new-tag"
          v-if="inputVisible"
          v-model="inputValue"
          ref="saveTagInput"
          size="mini"
          @keyup.enter.native="handleInputConfirm"
          @blur="handleInputConfirm"
        >
        </el-input>
        <el-button v-else class="button-new-tag" size="small" @click="showInput">+ New Tag</el-button>
      </div>
      <div class="edit-row">
        <textarea id="editor"></textarea>
      </div>
      <div class="edit-row">
        <button @click="newArticle()">YEAH</button>
      </div>
    </div>
    <div class="right-panel">

    </div>
  </div>
</template>
<script>
  import SimpleMDE from 'simplemde';
  import md2html from 'src/lib/markdown';
  let mde;
  export default {
    data() {
      return {
        article: {
          title: "",
          tags: ["abc", "风云雄霸", "19x"],
          newTag: "",
          content: ""
        },
        inputVisible: false,
        inputValue: ''
      }
    },
    mounted() {
      console.log('hah');
      mde = new SimpleMDE({
        initialValue: this.content,
        autoDownloadFontAwesome: true,
        element: document.getElementById('editor'),
        previewRender: str => md2html(str),
        spellChecker: false,
        toolbar: ['bold', 'italic', 'strikethrough', 'heading-1', 'heading-2', 'heading-3', 'clean-block', '|', 'code', 'quote', 'unordered-list', 'ordered-list', 'table', '|', 'link', 'image', 'horizontal-rule', {
          name: 'more',
          action: function customFunction (editor) {
            //  fix me
          },
          className: 'fa fa-chevron-circle-down',
          title: 'More'
        }, '|', 'preview', 'side-by-side', 'fullscreen', '|', 'guide']
      });
    },
    methods: {
      newArticle: function() {
        var self = this;
        $.ajax({
          url: 'resources/article',
          method: 'POST',
          data: {
            title: self.article.title,
            tags: '',
            content: self.article.content
          }
        }).done(function(data) {
          alert(data);
        });
      },

      handleClose(tag) {
        this.article.tags.splice(this.article.tags.indexOf(tag), 1);
      },

      showInput() {
        this.inputVisible = true;
        this.$nextTick(_ => {
          this.$refs.saveTagInput.$refs.input.focus();
        });
      },

      handleInputConfirm() {
        let inputValue = this.inputValue;
        if (inputValue) {
          this.article.tags.push(inputValue);
        }
        this.inputVisible = false;
        this.inputValue = '';
      }
    }
  }
</script>
<style>
  @import url('../style/simplemde.css');
  .edit .left-panel {
    width: 40%;
    min-width: 800px;
    margin-left: 15%;
    margin-top: 20px;
    float: left;
  }

  .edit .right-panel {
    width: 20%;
    margin-left: 5%;
    float: left;
  }

  .edit .edit-row {
    margin-top: 20px;
  }

  .el-tag+.el-tag {
    margin-left: 10px;
  }

  .tag-row .el-button {
    margin-left: 10px
  }
</style>
