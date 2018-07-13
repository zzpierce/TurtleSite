<template>
  <div class="container">
    <div class="main">
      <pre>
        <code class="java">
          public class A() {}
        </code>
      </pre>
    </div>
  </div>
</template>
<script>
  import MyHeader from '../util/header.vue';
  export default {
    data() {
      return {

      }
    },
    mounted() {
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
  }
</style>
