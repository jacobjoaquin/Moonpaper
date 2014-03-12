import moonpaper.*;
import moonpaper.opcodes.*;

Controller moonpaper;

void setup() {
  size(50, 50);
//  frameRate(120);
  moonpaper = new Controller(this);  
  Canvas canvas1 = moonpaper.createCanvas();
  Canvas canvas2 = moonpaper.createCanvas();
  canvas1.setActive(false);

  Bouncy b1 = new Bouncy(new PVector(width / 2, height / 2), PVector.random2D(), new Patchable<Float>(20.0));
  Bouncy b2 = new Bouncy(new PVector(width / 2, height / 2), PVector.random2D(), new Patchable<Float>(10.0));
  b1.c = color(255, 255, 0);
  b2.c = color(0, 255, 255);
  
  int nFrames = 30;
  moonpaper.seq(new ClearCanvases());
  moonpaper.seq(new PushCanvas(canvas1, b1));
  moonpaper.seq(new PushCanvas(canvas2, b2));  
  moonpaper.seq(new Line(60, b1.radius, 10));
  moonpaper.seq(new Line(60, b2.radius, 20));
  moonpaper.seq(new Wait(nFrames));
  moonpaper.seq(new FlipActive());
  moonpaper.seq(new Wait(nFrames));
  moonpaper.seq(new PushCanvas(canvas1, new Mirror()));  
  moonpaper.seq(new PushCanvas(canvas2, new Mirror()));  
  moonpaper.seq(new Line(60, b1.radius, 20));
  moonpaper.seq(new Line(60, b2.radius, 10));
  moonpaper.seq(new Wait(nFrames));
  moonpaper.seq(new FlipActive());
  moonpaper.seq(new Wait(nFrames));
}

void draw() {
  background(64, 0, 0);
  moonpaper.update();
  moonpaper.display();
}

