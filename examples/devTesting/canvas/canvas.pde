import moonpaper.*;

Canvas canvas;

void setup() {
  size(500, 500);
  canvas = new Canvas(this, width, height);
  
  for (int i = 0; i < 200; i++) {
    Bouncy b = new Bouncy(new PVector(width / 2, height / 2), PVector.random2D(), random(5, 20));
    b.blendMode = BLEND;
    canvas.add(b);
  }
}

void draw() {
  background(255, 0, 128);
  canvas.update();
  canvas.display();
}
