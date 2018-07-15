<template>
  <div class="tag-panel">
    <span class="tag-span" v-for="t in tags" v-bind:key="t.id" @click="searchBlog(t.name)">
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
  .tag-panel .tag-span:hover {
    cursor: pointer;
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
        tags: [],
        chosenTag: -1
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
        this.$emit('search-tag', text);
      }
    }
  }
</script>
