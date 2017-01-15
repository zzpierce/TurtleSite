<template>
  <div class="container">
    <ul class="nav">
      <li>
        <router-link to="home">HOME</router-link>
      </li>
      <li>
        <router-link to="blog">BLOG</router-link>
      </li>
      <li>
        <router-link to="home">TRINKETS</router-link>
      </li>
      <li>
        <router-link to="home">RUNES</router-link>
      </li>
    </ul>
    <router-view></router-view>
  </div>
</template>
<script></script>
<style>
  .container {
    width: 60%;
    margin: 0 20%;
  }

  .nav {
    position: absolute;
    top: 0;
    text-align: center;
    font-size: 1.5em;
    list-style: none;
    padding: 0;
    margin-left: 16%;
  }

  .nav li {
    display: inline-block;
    margin-bottom: 20px;
    margin-right: 20px;
    padding: 4px;
    background-color: #f0f0f0;
  }

  .nav li a, a:hover, a:active {
    color: #000;
    text-decoration: none;
  }
</style>
