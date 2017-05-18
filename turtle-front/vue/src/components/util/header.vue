<template>
  <div class="my-header">
    <div class="icon-span">T</div>
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
</template>

<style>
  .my-header {
    margin-top: 0;
    margin-left: auto;
    margin-right: auto;
    width: 100%;
    background-color: cadetblue;
    color: white;
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

  .my-header div, .my-header li{
    display: inline-block;
  }
</style>
<script>
  export default {
    data() {
      return {
        userName: "zz"
      }
    }
  }
</script>
