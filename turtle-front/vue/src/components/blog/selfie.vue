<template>
  <div class="container">
    <div class="main">计划？不存在的。</div>
  </div>
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
<style scoped>
  .main {
    text-align: center;
    margin-top: 20%;
    font-size: 6em;
  }
</style>
