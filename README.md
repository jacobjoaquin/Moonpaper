Welcome to Moonpaper, a modular environment for layers and sequencing. This is alpha software that has only been tested with Processing 2.0.3 64-bit mode on OS X. 

## Why Moonpaper

This library is designed to make somethings easier to do, specifically working with layers and sequencing routines.

### Layers with StackPGraphics

The new StackPGraphics will save keystrokes and help organize sketches the utilize multiple PGraphics. Let's look at an example of a sketch that uses a PGraphic the old way, and then the same sketch compared using a StackPGraphics object:

```
void drawSomeCircles(PGraphics pg) {
  pg.colorMode(HSB);
  pg.noStroke();
  for (int i = 0; i < 100; i++) {
    pg.fill(random(255), 255, 255);
    pg.ellipse(random(pg.width), random(pg.height), 20, 20);
  }
}

void setup() {
  size(500, 500);
  noLoop();
  background(0);
  
  PGraphics circleLayer = createGraphics(250, 250);
  circleLayer.beginDraw();
  drawSomeCircles(circleLayer);
  circleLayer.endDraw();
  image(circleLayer, 0, 0);
  filter(BLUR, 10);
  image(circleLayer, 0, 0);  
}
```


```
import moonpaper.*;

StackPGraphics stackpg;

void drawSomeCircles() {
  colorMode(HSB);
  noStroke();
  for (int i = 0; i < 100; i++) {
    fill(random(255), 255, 255);
    ellipse(random(width), random(height), 20, 20);
  }
}

void setup() {
  size(500, 500);
  stackpg = new StackPGraphics(this);
  noLoop();
  
  background(0);
  PGraphics circleLayer = stackpg.push(250, 250);
  drawSomeCircles();
  stackpg.pop(BLEND);  
  filter(BLUR, 10);
  image(circleLayer, 0, 0);  
}
```

* drawSomeCircles() is now modularized without requiring having to pass a PGraphics object or prepend methods with "pg".
* Global variables width and height are updated to reflect the current StackPGraphics layer.
* When StackPGraphics.pop() writes copies the current PGraphics to the layer underneath when a mode is passed as an argument. This uses blendMode() internally. If no arg is passed, the PGraphics is not copied below.
* beginDraw() and endDraw() are replaced with push() and pop().
