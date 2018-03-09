<template>
  <div class="main">
    <h1>
      Sorry, Server is crashing<span>{{dots}}</span>
    </h1>
    <div @click="toBlog">REALLY?</div>
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
<style scoped>
  .main > div {
    color: white;
    display: inline-block;
  }
  .main > div:hover {
    color: blue;
    cursor: pointer;
  }
</style>
<style>
  body {
    background-color: #f2f4f5;
    color: #1a1a1a;
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
  }
</style>
