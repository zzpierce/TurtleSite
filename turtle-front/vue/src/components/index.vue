<template>
  <div class="main">
    <h3>
      sorry, server is not responding<span>{{dots}}</span>
    </h3>
    <div @click="toBlog">except to you.</div>
  </div>
</template>
<script>
  module.exports = {
    data() {
      return {
        dots: "."
      }
    },
    mounted() {
      setInterval(this.appendDots, 200);
    },
    methods: {
      appendDots() {
        this.dots += ".";
        if(this.dots === ".......") {
          this.dots = "";
        }
      },
      toBlog() {
        this.$router.push({
          path: 'blog/list'
        })
      }
    }
  }
</script>
<style>
  body {
    background-color: #f2f4f5;
    color: #1a1a1a;
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  }
</style>
<style scoped>
  .main {
    margin-left: 40px;
  }
  .main > div {
    color: #f2f4f5;
    display: inline-block;
  }
  .main > div:hover {
    color: hotpink;
    cursor: pointer;
  }
</style>

