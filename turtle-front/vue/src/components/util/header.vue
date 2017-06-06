<template>
  <div class="my-header">
    <div class="header-main">
      <div class="icon-div" @click="toUrl('blog-list')">
        <img src="../../assets/turtle.png">
      </div>
      <div class="menu-div">
        <ul class="header-menu">
          <transition>
          <li @click="chosen(1)" v-bind:class="{'chosen-li':chosenFirst}">
            <router-link class="menu-link" to="/blog/list">
              技术总结
            </router-link>
          </li>
          </transition>
          <li @click="chosen(2)" v-bind:class="{'chosen-li':chosenSecond}">
            <router-link class="menu-link" to="/blog/selfie">人生规划</router-link>
          </li>
          <li @click="chosen(3)" v-bind:class="{'chosen-li':chosenThird}">
            <router-link class="menu-link" to="/blog/list">广告招租</router-link>
          </li>

        </ul>
      </div>
      <div class="log-div">
        {{userName}}
      </div>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        userName: "zzpierce",
        chosenList: 0
      }
    },
    computed: {
      chosenFirst: function() {
        return this.chosenList === 1;
      },
      chosenSecond: function() {
        return this.chosenList === 2;
      },
      chosenThird: function() {
        return this.chosenList === 3;
      }
    },
    methods: {
      toUrl(url) {
        this.$router.push({
          name : url
        })
      },
      chosen(index) {
        this.chosenList = index;
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
    position: fixed;
    top: 0;
    left: 0;
    z-index: 20;
    width: 100%;
    height: 45px;
    background-color: #5f9ea0;
    color: white;
  }

  .header-main {
    position: relative;
    height: inherit;
    width: 70%;
    margin: auto;
  }

  .header-main .chosen-li{
    background-color: #6FAEB0;
  }

  .icon-div {
    float: left;
    width: 40px;
  }

  .icon-div:hover {
    cursor: pointer;
  }

  .icon-div img {
    width: 100%;
    margin: 6px 0;
  }

  .menu-div {
    float: left;
  }

  ul {
    list-style: none;
    padding: 0;
    margin: 0 0 0 20px;
  }

  li {
    padding: 0 10px;
  }

  li:hover {
    cursor: pointer;
    color: #eee;
  }

  .menu-link {
    text-decoration: none;
    height: 45px;
    line-height: 45px;
    text-align: center;
    display: block;
    color: #f2f4f5;
    text-shadow: 0 1px 1px rgba(0,0,0,.12);
    font-size: 14px;
  }

  .menu-link:hover {
    cursor: pointer;
  }

  .log-div {
    margin: 16px;
    float: right;
  }

  .header-main div, .header-main li{
    display: inline-block;
  }
</style>
