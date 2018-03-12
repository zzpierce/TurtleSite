<template>
  <div class="container">
    <canvas id="drawing"></canvas>
  </div>
</template>
<script>

  export default {
    data() {
      return {
        ctx: "",
        position: {
          x: 0,
          y: 0
        },
        speed: {
          xs: 3,
          ys: 0
        },
        g: 0.4,
        side: 50
      }
    },
    mounted() {
      let canvas = document.querySelector('canvas');
      canvas.width = window.innerWidth;
      canvas.height = window.innerHeight;
      this.ctx = canvas.getContext('2d');
      this.draw();
    },
    methods: {
      draw() {
        this.ctx.fillStyle = 'green';
        this.ctx.lineWidth = 0.3;
        setInterval(this.move, 5);
      },
      move() {
        this.ctx.clearRect(this.position.x - 100, this.position.y - 100, this.side + 200, this.side + 200);
        this.speed.ys += this.g;
        this.position.x += this.speed.xs;
        this.position.y += this.speed.ys;
        this.ctx.fillRect(this.position.x, this.position.y, this.side, this.side);
        if (this.position.y > window.innerHeight) {
          this.position.y = window.innerHeight;
          this.speed.ys *= -1;
        }
        if (this.position.x < 0 || this.position.x > window.innerWidth) {
          this.speed.xs *= -1;
        }
      }
    }
  }
</script>
