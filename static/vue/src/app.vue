<template>
  <div class="container">
    <ul class="nav">
      <li>
        <router-link to="/home">HOME</router-link>
      </li>
      <li>
        <router-link to="/blog">BLOG</router-link>
      </li>
      <li>
        <router-link to="/backend">TRINKETS</router-link>
      </li>
      <li>
        <router-link to="/home">RUNES</router-link>
      </li>
    </ul>
    <router-view></router-view>
  </div>
</template>
<script></script>
<style>
  @import url("./style/my.css");
  .container {
    width: 100%;
    margin: 0;
  }

  .nav {
    list-style: none;
    padding: 0;
    margin: 0;
    background-color: #1a5952;

  }

  .nav li {
    display: inline-block;
    margin-left: 13px;
  }

  .nav li:last-child {
    border-right: none;
  }

  .nav li a {
    color: #fff;
    text-decoration: none;
  }

  .nav li a:hover, a:active {
    color: #AAA;
  }
</style>
