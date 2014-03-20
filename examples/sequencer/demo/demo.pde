import moonpaper.*;
import moonpaper.opcodes.*;

Moonpaper mp;
StackPGraphics stackpg;
PGraphics img;

void setup() {
  size(500, 500);
  mp = new Moonpaper(this);
  stackpg = new StackPGraphics(this);  
  Cel cel0 = mp.createCel();
  
  colorMode(HSB);
  
  mp.seq(new ConsoleWrite("Start of Sequencer Loop"));
  mp.seq(new ClearCels());
  
  int nDots = 4;
  for (int i = 0; i < nDots; i++) {
    PImage dot = makeDot(200, 9, color(map(i, 0, nDots, 0, 255), 255, 255));
    PVector startLocation = new PVector(width / 2, height / 2);
    PVector velocity = PVector.mult(PVector.fromAngle(map(i, 0, nDots, 0, TWO_PI)), 4);
    MovingImage m = new MovingImage(dot, startLocation, velocity);
    m.setBlendMode(SCREEN);

    mp.seq(new PushCel(cel0, m));
    mp.seq(new Wait(60));
  }
  
  mp.seq(new Wait(600));
}

void draw() {
  background(0);
  mp.update();
  mp.display();
}

