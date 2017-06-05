<template>
  <div class="container">
    <my-header></my-header>
    <div class="main">
      <router-view></router-view>
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
    components: {
      'my-header': MyHeader
    }
  }
</script>

