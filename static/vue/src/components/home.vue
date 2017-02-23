<template>
  <div>
    <div class="meat" >
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
    font-size: 15px;
    color: #222;
    margin: 0;
    padding: 0;
  }

  .meat {
    font-size: 9em;
    text-align: center;
    font-family: "Microsoft JhengHei", sans-serif;
  }

  .meat ul {
    padding: 0;
  }

  .meat ul>li {
    display: inline-block;
  }

  .meat ul>li:hover {
    cursor: pointer;
    color: white;
  }

  .signature {
    position: absolute;
    bottom: 0;
  }
</style>
