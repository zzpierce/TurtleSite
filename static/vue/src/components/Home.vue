<template>
  <div class="container" v-bind:style="bgAttr">
    <div class="title" >
      <ul>
        <li @mouseover="fancy(1)">个</li>
        <li @mouseover="fancy(2)">人</li>
        <li @mouseover="fancy(3)">主</li>
        <li @mouseover="fancy(0)">页</li>
      </ul>
    </div>
    <div class="signature">zz</div>
  </div>
</template>
<script>

  export default {
    data: function() {
      return {
        value: "123",
        bgAttr: {
          "background-color": "darkkhaki"
        },
        colors: [
          "cadetblue",
          "bisque",
          "darkgray",
          "coral"
        ]
      };
    },
    methods: {
      fancy(v) {
        this.bgAttr["background-color"] = this.colors[v];
      }
    }
  };
</script>
<style>
  html, body {
    font-size: 12px;
    font-family: "Microsoft YaHei",Arial,Helvetica,sans-serif;
    background-color: darkkhaki;
    color: #222;
    -webkit-tap-highlight-color: transparent;
  }

  .container {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
  }

  .container .title {
    font-size: 10em;
    text-align: center;
    font-family: "Microsoft JhengHei", sans-serif;
    padding-top: 4%;
    padding-bottom: 4%;
  }

  .title ul {
    padding: 0;
  }

  .title ul>li {
    display: inline-block;
  }

  .title ul>li:hover {
    cursor: pointer;
    color: white;
  }

  .container .signature {
    position: absolute;
    bottom: 0;
  }
</style>
