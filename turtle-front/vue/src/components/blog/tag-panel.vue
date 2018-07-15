<template>
  <div class="tag-panel">
    <span v-for="t in tags" v-bind:key="t.id" @click="searchBlog(t.name)">
      <el-tag class="el-tag" type="info">
        {{t.name}}
      </el-tag>
    </span>
  </div>
</template>
<style scoped>
  .tag-panel {
    margin: 10px 0;
  }
  .el-tag {
    margin-bottom: 10px;
    margin-right: 10px;
  }
</style>
<script>
  import { POST_RESULT, API } from '../../util/constants';
  export default {
    data() {
      return {
        tags: []
      }
    },
    mounted() {
      this.init();
    },
    methods: {
      init() {
        this.$http.get(API.GET_ALL_TAGS).then(res => {
          if (res.status !== 200 || res.data.code !== POST_RESULT.SUCCESS) {
            console.error('load tags failed');
          } else {
            this.tags = res.data.data;
          }
        });
      },
      searchBlog(text) {
        console.log('emit' + text);

        this.$emit('search-tag', text);
      }
    }
  }
</script>
