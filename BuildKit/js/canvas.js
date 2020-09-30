var isResultExists = false;

class Canvas {
    constructor(el) {
        const ctx = el.getContext('2d');
        const length = 300;
        const pixel = 10;
        const poThis = this;

        let is_mouse_down = false;

        el.width = length;
        el.height = length;

        this.drawLine = function (x1, y1, x2, y2) {
          ctx.beginPath();
          ctx.strokeStyle = 'gray';
          ctx.lineJoin = 'miter';
          ctx.lineWidth = 1;
          ctx.moveTo(x1, y1);
          ctx.lineTo(x2, y2);
          ctx.stroke();
        }

        this.drawCell = function(x, y, w, h) {
          ctx.fillStyle = 'blue';
          ctx.strokeStyle = 'blue';
          ctx.lineJoin = 'miter';
          ctx.lineWidth = 1;
          ctx.rect(x, y, w, h);
          ctx.fill();
        }

        this.drawGrid = function() {
          const l = length;
          const p = l / pixel;
          const step = l / p;

          for (let i = 0; i < l; i += step) {
            this.drawLine(i, 0, i, l);
            this.drawLine(0, i, l, i);
          }
        }

        this.clear = function() {
          ctx.clearRect(0, 0, el.width, el.height);
        }

        this.calculate = function(draw = false) {
          const p = length / pixel;
          const step = length / p;

          const vector = [];
          let __draw = [];

            for(let x = 0; x < length; x += step) {
                for(let y = 0; y < length; y += step) {
                    const data = ctx.getImageData(x, y, step, step);

                    let nonEmptyPixelsCount = 0;
                    for(let i = 0; i < data.data.length; i += 10) {
                        const isEmpty = data.data[i] === 0;

                        if(!isEmpty) {
                            nonEmptyPixelsCount += 1;
                        }
                    }

                    if(nonEmptyPixelsCount > 1 && draw) {
                        __draw.push([x, y, step, step]);
                    }

                    vector.push(nonEmptyPixelsCount > 1 ? 1 : 0);
                }
          }

      if(draw) {
        this.clear();
        this.drawGrid();

        for(let _d in __draw) {
          this.drawCell(__draw[_d][0], __draw[_d][1], __draw[_d][2], __draw[_d][3]);
        }
      }

      return vector;
    }

    el.addEventListener('mousedown', function(e) {
      if (isResultExists) {
        poThis.clear()
        isResultExists = false;
      }
      is_mouse_down = true;
      ctx.beginPath();
    });

    el.addEventListener('mouseup', function(e) {
      is_mouse_down = false;
    });

    el.addEventListener('mousemove', function(e) {
      if(is_mouse_down) {
        ctx.fillStyle = 'red';
        ctx.strokeStyle = 'red';
        ctx.lineWidth = pixel;

        ctx.lineTo(e.offsetX, e.offsetY);
        ctx.stroke();

        ctx.beginPath();
        ctx.arc(e.offsetX, e.offsetY, pixel / 2, 0, Math.PI * 2);
        ctx.fill();

        ctx.beginPath();
        ctx.moveTo(e.offsetX, e.offsetY);
      }
    });
  }
}
