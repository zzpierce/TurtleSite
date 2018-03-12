<template>
  <div class="container">
    <canvas id="drawing" width="600px" height="400px"></canvas>
  </div>
</template>
<script>

  export default {
    data() {
      return {
        ctx: "",
        x: 0,
        y: 0
      }
    },
    mounted() {
      let canvas = document.querySelector('canvas');
      this.ctx = canvas.getContext('2d');
      this.draw();
    },
    methods: {
      draw() {
        this.ctx.fillStyle = 'green';
        this.ctx.lineWidth = 0.3;
        setInterval(this.move, 20);
      },
      move() {
        this.x += 1;
        this.y += 1;
        this.ctx.fillRect(this.x, this.y, 50, 50);
      }
    }
  }
</script>
