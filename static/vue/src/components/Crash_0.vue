<template>
  <div>
    <canvas id='canvas'></canvas>
  </div>
</template>
<style>

</style>
<script>

  class Draw {

    constructor(el) {
      this.el = el;
      this.canvas = document.getElementById(this.el);
      this.ctx = this.canvas.getContext('2d');
      this.wHeight = window.innerHeight;
      this.wWidth = window.innerWidth;
      console.log(this.wWidth);
    }

    init() {

      this.canvas.height = this.wHeight;
      this.canvas.width = this.wWidth;

      this.ctx.fillStyle = 'green';

      var cx1= 100, cy1 = 100;
      var cx2 = this.wWidth/2, cy2 = this.wHeight/2;
      var dx=0, dy=0;
      var radius = 50;

      draw();

      function draw() {

        this.ctx.clearRect(0, 0, this.wWidth, this.wHeight);
        this.ctx.beginPath();
        this.ctx.fillStyle = '#337799';
        this.ctx.arc(cx1, cy1, radius, 0, Math.PI * 2);
        this.ctx.fill();
        this.ctx.closePath();
        this.ctx.beginPath();
        this.ctx.fillStyle = '#cccc66';
        this.ctx.arc(cx2, cy2, radius*2, 0, Math.PI * 2);
        this.ctx.fill();
        this.ctx.closePath();

        requestAnimationFrame(draw);
      }



      function ptop(x1, y1, x2, y2) {
        return Math.sqrt(
          (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)
        );
      }

      var isDrag = false;
      document.addEventListener('mousedown', function(e) {
        var mx = e.clientX;
        var my = e.clientY;

        dx = mx - cx1; dy = my - cy1;
        if(dx*dx + dy*dy <= radius * radius) {
          isDrag = true;
        }

      });

      document.addEventListener('mousemove', function(e) {
        var mx = e.clientX;
        var my = e.clientY;

        if (isDrag) {
          cx1 = mx - dx; cy1=my - dy;
          if(isCrash()) {
            var _dx = cx1 - cx2;
            var _dy = cy1 - cy2;
            var _dlen = Math.sqrt( _dx*_dx + _dy*_dy );
            cx1 = cx2 + _dx * (radius) * 3 / _dlen;
            cy1 = cy2 + _dy * (radius) * 3 / _dlen;
          }
        }

        function isCrash() {
          return ptop(cx1, cy1, cx2, cy2) <= radius * 3;
        }

      });

      document.addEventListener('mouseup', function(e) {
        isDrag = false;
      });

      window.onresize = function() {
        this.wHeight = window.innerHeight;
        this.wWidth = window.innerWidth;
        canvas.height = this.wHeight;
        canvas.width = this.wWidth;
        cx2 = this.wWidth/2; cy2 = this.wHeight/2;
      };
    }

  }


  export default {

    ready() {
      alert('ggll');
      let draw = new Draw('canvas');
      draw.init();
    }

  }
</script>
