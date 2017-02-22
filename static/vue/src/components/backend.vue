<template>
  <div>
    <label>
      <span class="iconfont icon-add"></span>
    </label>
    <div class="bottom-panel">
      <div class="bottom-row">
        <label>标题：</label>
        <input type="text" v-model="addArticle.title"/>
      </div>
      <div class="bottom-row">
        <label>内容：</label>
        <textarea id="editor"></textarea>
      </div>
      <div class="bottom-row">
        <button @click="newArticle()">YEAH</button>
      </div>
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
        addArticle: {
          title: "",
          tags: [],
          content: ""
        }
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
            title: self.addArticle.title,
            tags: '',
            content: self.addArticle.content
          }
        }).done(function(data) {
          alert(data);
        });
      }
    }
  }
</script>
<style>
  @import url('../style/simplemde.css');
</style>
