<template>
  <el-container>
    <el-header>
      <my-header></my-header>
    </el-header>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>
<script>
  import MyHeader from '../util/header.vue';

  export default {
    data() {
      return {

      }
    },
    components: {
      'my-header': MyHeader
    }
  }
</script>

