import moonpaper.*;
import moonpaper.opcodes.*;

Moonpaper mp;
StackPGraphics stackpg;
PGraphics img;

void setup() {
  size(400, 400);
  mp = new Moonpaper(this);
  stackpg = new StackPGraphics(this);  
  Cel cel0 = mp.createCel();
  Cel cel1 = mp.createCel();
  cel1.setActive(false);
  cel1.setTransparency(0.0);
  
  colorMode(HSB);
  
  mp.seq(new ConsoleWrite("Start of Sequencer Loop"));
  mp.seq(new ClearCels());
  mp.seq(new PushCel(cel0, new SetBackground()));
  mp.seq(new PushCel(cel1, new SetBackground()));
  
  int nDots = 4;
  for (int i = 0; i < nDots; i++) {
    color c = color(map(i, 0, nDots, 0, 255), 255, 255);
    PImage dot = makeDot(200, 7, c);
    PVector startLocation = new PVector(width / 2, height / 2);
    PVector velocity = PVector.mult(PVector.fromAngle(map(i, 0, nDots, 0, TWO_PI) + QUARTER_PI), i + 4);
    MovingImage m = new MovingImage(dot, startLocation, velocity);
    m.setBlendMode(SCREEN);

    mp.seq(new PushCel(cel0, m));
  }
  
  mp.seq(new Wait(60));
  mp.seq(new FadeOut(120, cel0));
  mp.seq(new PushCel(cel0, new Mirror()));
  mp.seq(new FadeIn(120, cel0));

  nDots = 16;
  for (int i = 0; i < nDots; i++) {
    color c = color(map(i, 0, nDots, 0, 255), 255, 255);
    PImage dot = makeDot(50, 7, c);
    PVector startLocation = new PVector(map(i, 0, nDots - 1, 0, width), map(i, 0, nDots - 1, 0, height));
    PVector velocity = PVector.mult(PVector.fromAngle((i % 2) * PI), 4);
    MovingImage m = new MovingImage(dot, startLocation, velocity);
    m.setBlendMode(SCREEN);

    mp.seq(new PushCel(cel1, m));
  }

  mp.seq(new CrossFade(120, cel0, cel1));
  mp.seq(new PopCel(cel0));
  mp.seq(new Wait(250));
  mp.seq(new CrossFade(120, cel1, cel0));
}

void draw() {
//  println(frameRate);
  background(0);
  mp.update();
  mp.display();
}

