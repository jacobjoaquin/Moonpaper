import moonpaper.*;
import moonpaper.opcodes.*;

Controller moonpaper;
Canvas canvas1;
Canvas canvas2;

void setup() {
  size(100, 100);
//  frameRate(15);
  moonpaper = new Controller(this);  
  canvas1 = moonpaper.createCanvas();
  canvas2 = moonpaper.createCanvas();
  canvas1.setActive(false);

  Patchable<Float> radius = new Patchable<Float>(45.0);
  Bouncy b1 = new Bouncy(new PVector(width / 2, height / 2), PVector.random2D(), radius);
  Bouncy b2 = new Bouncy(new PVector(width / 2, height / 2), PVector.random2D(), new Patchable<Float>(45.0));
  b1.c = color(255, 255, 0);
  b2.c = color(0, 255, 255);
  
  int nFrames = 10;
  moonpaper.seq(new ClearCanvases());
  moonpaper.seq(new Line(60, b1.radius, 15));
  moonpaper.seq(new Line(60, b2.radius, 30));
  moonpaper.seq(new PushCanvas(canvas1, b1));
  moonpaper.seq(new PushCanvas(canvas2, b2));  
  moonpaper.seq(new Wait(nFrames));
  moonpaper.seq(new FlipActive());
  moonpaper.seq(new Wait(nFrames));
  moonpaper.seq(new PushCanvas(canvas1, new Mirror()));  
  moonpaper.seq(new PushCanvas(canvas2, new Mirror()));  
  moonpaper.seq(new Wait(nFrames));
  moonpaper.seq(new FlipActive());
  moonpaper.seq(new Wait(nFrames));
}

void draw() {
  println("FrameNumber:   " + frameCount);
  background(64, 0, 0);
  moonpaper.update();
  moonpaper.display();
}

