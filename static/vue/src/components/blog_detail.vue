<template>
  <div>
    <h2>{{article.title}}</h2>
    <p>{{article.content}}</p>
  </div>
</template>
<script>
  import $ from 'jquery';
  export default {
    data: function() {
      return {
        blogId: 0,
        article: {}
      }
    },
    created: function() {
      this.blogId = this.$route.params.id;
      //this.loadArticle();
    },
    methods: {
      loadArticle: function() {
        var self = this;
        $.get('resources/article/' + self.blogId, function(data) {
          var dataJson = JSON.parse(data);
          if(dataJson.length > 0) {
            self.article = dataJson[0];
          }

        });
      }
    }
  }
</script>
<style>

</style>
