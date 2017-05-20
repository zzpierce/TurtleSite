<template>
  <div class="my-header">
    <div class="header-main">
      <div class="icon-span" @click="toUrl('blog-list')">T</div>
      <div class="menu-div">
        <ul class="header-menu">
          <li>人生规划</li>
          <li>技术总结</li>
          <li>瞎JB写</li>
        </ul>
      </div>
      <div class="log-div">
        zzpierce
      </div>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        userName: "zz"
      }
    },
    methods: {
      toUrl(url) {
        this.$router.push({
          name : url
        })
      }
    }
  }
</script>

<style>
  body {
    margin: 0;
  }
</style>

<style scoped>


  .my-header {
    margin-top: 0;
    margin-left: auto;
    margin-right: auto;
    width: 100%;
    background-color: cadetblue;
    color: white;
  }

  .header-main {
    width: 70%;
    margin: auto;
  }

  .icon-span {
    font-size: 1.7em;
    color: white;
    margin-left: 0.5em;
  }

  .header-menu {
    list-style: none;
  }

  .log-div {
    margin: 16px;
    float: right;
  }

  .header-main div, .header-main li{
    display: inline-block;
  }
</style>
