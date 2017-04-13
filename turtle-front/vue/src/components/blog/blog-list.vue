<template>
  <div class="main">
    <ul>
      <li v-for="blog in blogList">
        {{blog.title}}
      </li>
    </ul>
  </div>
</template>
<script>
  import {DEV_URL} from '../../util/constants';

  export default {
    data() {
      return {
        blogList: []
      }
    },
    mounted() {
      this.loadBlogs();
    },
    methods: {
      loadBlogs() {
        this.$http.get(DEV_URL.LOAD_BLOG_LIST)
          .then(res => {
            this.blogList = res.data;
          })
          .catch(res => {
            console.log("error happens when load blogs.");
          });
      }
    }
  }
</script>
