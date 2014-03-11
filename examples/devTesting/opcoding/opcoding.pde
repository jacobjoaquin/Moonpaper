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
  canvas2.setActive(false);

  Bouncy b1 = new Bouncy(new PVector(width / 2, height / 2), PVector.random2D(), 50);
  Bouncy b2 = new Bouncy(new PVector(width / 2, height / 2), PVector.random2D(), 50);

  controller.addOpcode(new ClearCanvases());
  controller.addOpcode(new PushCanvas(canvas1, b1));
  controller.addOpcode(new PushCanvas(canvas2, b2));  
  controller.flipActive();
  controller.wait(15);
  controller.addOpcode(new FlipActive());
  controller.addOpcode(new Wait(60));
  
//  controller.addOpcode(new PushCanvas(canvas1, new Mirror()));  
//  controller.addOpcode(new PushCanvas(canvas2, new Mirror()));  
//  controller.addOpcode(new Wait(3 * 60));
//  controller.addOpcode(new FlipActive());
//  controller.addOpcode(new Wait(3 * 60));
}

void draw() {
  background(0);
  controller.update();
  controller.display();
}

