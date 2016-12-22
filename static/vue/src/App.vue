<template>
  <div id="app">
    <div class='left-panel'>
      <h1>Mis Engine</h1>
      <ul>
        <li @click='switchPage(0)'>/</li>
        <li @click='switchPage(1)'>/about</li>
        <li @click='switchPage(2)'>/crash_0</li>
      </ul>
    </div>
    <div class='right-panel'>
      <home v-if='page == 0'></home>
      <about v-if='page == 1'></about>
    </div>

  </div>
</template>

<script>
  import About from './components/About.vue'
  import Home from './components/Home.vue'
  import Vue from 'vue'
  export default {
    data() {
      return {
        page: 0
      }
    },
    components: {
      Home,
      About,

    },
    methods: {
      switchPage: function(num) {
        this.page = num;
        let d = new Vue({template: '<div>aaa</div>'});
        d.$appendTo('.right-panel', function(){

        });
      }
    },
    created() {
      console.log('created');
    },
    beforeCompile() {
      console.log('beforeCompile');
    },
    compiled() {
      console.log('compiled');
    },
    ready() {
      console.log('ready');
    },
    attached() {
      console.log('attached');
    },
    detached() {
      console.log('detached');
    }
  }
</script>

<style>
html {
  height: 100%;
}

body {
  height: 100%;
}

#app {
  color: #2c3e50;
  font-family: Source Sans Pro, Helvetica, sans-serif;
  text-align: center;
}

#app a {
  color: #42b983;
  text-decoration: none;
}

.left-panel {
  width: 20%;
  float: left;
  background-color: #cc3333;
}

.logo {
  width: 100px;
  height: 100px
}
</style>
