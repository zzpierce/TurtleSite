<template>
  <div class="container">
    <div class="canvas-div">
      <canvas id="drawing"></canvas>
    </div>
  </div>
</template>
<script>

  export default {
    data() {
      return {
        wHeight: 600,
        wWidth: 800,
        ctx: '',
        position: {
          x: 300,
          y: 300
        },
        speed: {
          jump: -12,
          xs: 0,
          ys: 0
        },
        g: 0.4,
        meImg: '',
        me: {
          air: false
        }
      }
    },
    mounted() {
      let canvas = document.querySelector('canvas');
      canvas.width = this.wWidth;
      canvas.height = this.wHeight;
      this.ctx = canvas.getContext('2d');
      this.draw();
    },
    methods: {
      draw() {
        this.ctx.fillStyle = 'green';
        this.ctx.lineWidth = 0.3;
        setInterval(this.move, 10);

        this.meImg = new Image();
        this.meImg.src = "http://the-tinysaur-generator.herokuapp.com/?small=true&2";

        window.addEventListener('keydown', e => {
          if (!this.me.air && e.keyCode === 13) {
            this.jump();
          }
        });

      },
      move() {
        this.ctx.clearRect(this.position.x - 100, this.position.y - 100, 600, 600);
        this.speed.ys += this.g;
        this.position.x += this.speed.xs;
        this.position.y += this.speed.ys;
        this.ctx.drawImage(this.meImg, this.position.x, this.position.y);
        if (this.position.y > this.wHeight - 200) {
          this.position.y = this.wHeight - 200;
          this.speed.ys = 0;
          this.me.air = false;
        }
        if (this.position.x < 0 || this.position.x > window.innerWidth) {
          this.speed.xs *= -1;
        }
      },
      jump() {
        this.speed.ys = this.speed.jump;
        this.me.air = true;
      }
    }
  }
</script>
<style scoped>
  .container {
    width: 100%;
    height: 100%;
    text-align: center;
  }
  .canvas-div {
    vertical-align: center;
  }
  canvas {
    border: 1px solid red;
    margin-top: 10%;
  }
</style>
