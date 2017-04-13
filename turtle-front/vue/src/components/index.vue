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
          name: 'blog-list'
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
