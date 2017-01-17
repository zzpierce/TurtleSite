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
        <router-link to="/home">TRINKETS</router-link>
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

  .container {
    width: 50%;
    margin: 0 25%;
  }

  .nav {
    text-align: center;
    font-size: 1.5em;
    list-style: none;
    padding: 0;
  }

  .nav li {
    display: inline-block;
    margin-bottom: 20px;
    width: 20%;
    border-right: 1px solid #f0f0f0;
  }

  .nav li:last-child {
    border-right: none;
  }

  .nav li a {
    color: #333;
    text-decoration: none;
  }

  .nav li a:hover, a:active {
    color: #666;
  }
</style>
