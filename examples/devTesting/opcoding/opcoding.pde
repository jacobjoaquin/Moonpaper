import moonpaper.*;
import moonpaper.opcodes.*;

Controller controller;
Canvas canvas1;
Canvas canvas2;

void setup() {
  size(500, 500);
  controller = new Controller(this);  
  canvas1 = controller.createCanvas();
  canvas2 = controller.createCanvas();
  canvas1.add(new Bouncy(new PVector(width / 2, height / 2), PVector.random2D(), 50));
  canvas2.add(new Bouncy(new PVector(width / 2, height / 2), PVector.random2D(), 50));
  canvas2.setActive(false);
  
  controller.flipActive();
  controller.wait(15);
  controller.addOpcode(new FlipActive());
  controller.addOpcode(new Wait(60));
}

void draw() {
  background(0);
  controller.update();
  controller.display();
}
