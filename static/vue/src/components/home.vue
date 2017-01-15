<template>
  <div class="container">
    <div class="title" >
      <ul>
        <li @mouseover="fancy(1)">M</li>
        <li @mouseover="fancy(2)">E</li>
        <li @mouseover="fancy(3)">A</li>
        <li @mouseover="fancy(0)">T</li>
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
          "background-color": "coral"
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

      }
    }
  };
</script>
<style>
  body {
    font-size: 12px;
    font-family: "Microsoft YaHei",Arial,Helvetica,sans-serif;
    color: #222;
    margin: 0;
    padding: 0;
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
