import moonpaper.*;

Controller controller;
Canvas canvas0;
Canvas canvas1;

void setup() {
  size(500, 500);
  controller = new Controller(this);
  canvas0 = controller.createCanvas();
  canvas1 = controller.createCanvas();
  
  PVector v1 = PVector.random2D();
  PVector v2 = PVector.random2D();
  v1.mult(3);
  v2.mult(3);
  
  Bouncy b1 = new Bouncy(new PVector(width / 2, height / 2), v1, 3);
  Bouncy b2 = new Bouncy(new PVector(50, 50), v2, 3);
  b1.c = color(255, 0, 0);
  b2.c = color(0, 0, 255);
  canvas0.add(b1);
  canvas1.add(b2);
}

void draw() {
  controller.update();
  controller.display();
}
