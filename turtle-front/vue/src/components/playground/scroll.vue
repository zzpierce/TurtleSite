<template>
  <div class="container">
    <h1>SCROLL</h1>
    <div v-for="item in itemList">
      <p>{{item.content}}</p>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        itemList: []
      }
    },
    mounted() {
      for (var i = 0; i < 100; i ++) {
        this.itemList.push({
          'content': '你不是真正的快乐'
        })
      }
      console.log(this.itemList);
    }
  }
</script>
