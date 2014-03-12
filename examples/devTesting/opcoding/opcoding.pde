import moonpaper.*;
import moonpaper.opcodes.*;

Controller controller;
Canvas canvas1;
Canvas canvas2;

void setup() {
  size(100, 100);
//  frameRate(2);
  controller = new Controller(this);  
  canvas1 = controller.createCanvas();
  canvas2 = controller.createCanvas();
  canvas2.setActive(false);

  Bouncy b1 = new Bouncy(new PVector(width / 2, height / 2), PVector.random2D(), 20);
  Bouncy b2 = new Bouncy(new PVector(width / 2, height / 2), PVector.random2D(), 20);
  b2.c = color(0, 255, 128);
  
  ModFloat someNumber = new ModFloat(200.0);
  
  int nFrames = 60;
  controller.seq(new ClearCanvases());
  controller.seq(new Line(5, someNumber, 100));
  controller.seq(new PushCanvas(canvas1, b1));
  controller.seq(new PushCanvas(canvas2, b2));  
  controller.seq(new Wait(nFrames));
  controller.seq(new FlipActive());
  controller.seq(new Wait(nFrames));
  controller.seq(new PushCanvas(canvas1, new Mirror()));  
  controller.seq(new PushCanvas(canvas2, new Mirror()));  
  controller.seq(new Wait(nFrames));
  controller.seq(new FlipActive());
  controller.seq(new Wait(nFrames));
}

void draw() {
  background(0);
  controller.update();
  controller.display();
}

