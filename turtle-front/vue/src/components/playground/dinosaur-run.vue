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
        ground: 400,
        ctx: '',
        ds: {
          air: false,
          p: {
            x: 300,
            y: 300,
            headLeft: false,
            headRight: false
          },
          speed: {
            jump: -12,
            xs: 0,
            ys: 0,
            run: 5
          }
        },
        g: 0.8,

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
        this.meImg = new Image();
        this.meImg.src = "http://the-tinysaur-generator.herokuapp.com/?small=true&2";
        this.move();

        window.addEventListener('keydown', e => {
//          console.log(e.keyCode);
          if (e.keyCode === 37) {
            this.ds.p.headLeft = true;
          }
          if (e.keyCode === 39) {
            this.ds.p.headRight = true;
          }
          if (!this.ds.air) {
            if (e.keyCode === 32) {
              this.jump();
            }
          }
        });

        window.addEventListener('keyup', e => {
          if (e.keyCode === 37) {
            this.ds.p.headLeft = false;
          }
          if (e.keyCode === 39) {
            this.ds.p.headRight = false;
          }
        });
      },
      move() {
        this.ctx.clearRect(0, 0, this.wWidth, this.wHeight);
        this.moveDinosaur();
        requestAnimationFrame(this.move);
      },
      jump() {
        this.ds.speed.ys = this.ds.speed.jump;
        this.ds.air = true;
      },
      moveDinosaur() {
        //change speed
        if (this.ds.p.headLeft) {
          if (this.ds.p.headRight) {
            this.ds.speed.xs = 0;
          } else {
            this.ds.speed.xs = - this.ds.speed.run;
          }
        } else {
          if (this.ds.p.headRight) {
            this.ds.speed.xs = this.ds.speed.run;
          } else {
            this.ds.speed.xs = 0;
          }
        }
        this.ds.speed.ys += this.g;
        this.ds.p.x += this.ds.speed.xs;
        this.ds.p.y += this.ds.speed.ys;

        //draw
        this.ctx.drawImage(this.meImg, this.ds.p.x, this.ds.p.y);

        //after draw
        if (this.ds.p.y > this.wHeight - 200) {
          this.ds.p.y = this.wHeight - 200;
          this.ds.speed.ys = 0;
          this.ds.air = false;
        }
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
    border: 1px solid #eee;
    margin-top: 10%;
  }
</style>
