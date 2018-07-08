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
        meImg: '',
        wHeight: 600,
        wWidth: 800,
        ctx: '',
        ds: {
          air: false,
          position: {
            x: 300,
            y: 300
          },
          speed: {
            jump: -12,
            xs: 0,
            ys: 0
          }
        },
        g: 0.4,

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
          if (!this.ds.air && e.keyCode === 13) {
            this.jump();
          }
        });

      },
      move() {
        this.ctx.clearRect(this.ds.position.x - 100, this.ds.position.y - 100, 600, 600);
        this.moveDinosaur();
      },
      jump() {
        this.ds.speed.ys = this.ds.speed.jump;
        this.ds.air = true;
      },
      moveDinosaur() {
        this.ds.speed.ys += this.g;
        this.ds.position.x += this.ds.speed.xs;
        this.ds.position.y += this.ds.speed.ys;
        this.ctx.drawImage(this.meImg, this.ds.position.x, this.ds.position.y);
        if (this.ds.position.y > this.wHeight - 200) {
          this.ds.position.y = this.wHeight - 200;
          this.ds.speed.ys = 0;
          this.ds.air = false;
        }
        if (this.ds.position.x < 0 || this.ds.position.x > window.innerWidth) {
          this.ds.speed.xs *= -1;
        }
      },
      moveObstacle() {

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
