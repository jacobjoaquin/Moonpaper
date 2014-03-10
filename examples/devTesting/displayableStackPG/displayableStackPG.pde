import moonpaper.*;

int nCircles = 16;
int circleSize = 100;
Canvas canvas;

void setup() {
  size(500, 500);
  frameRate(120);
  canvas = new Canvas(this, width, height);
  
  for (int i = 0; i < nCircles; i++) {
//    float angle = map(i, 0, nCircles, 0, QUARTER_PI);
    float angle = random(TWO_PI);
    Bouncy b = new Bouncy(new PVector(width / 2, height / 2), PVector.fromAngle(angle), circleSize);
    b.setBlendMode(DIFFERENCE);
    canvas.add(b);
  }
  
  canvas.add(new Mirror());
  Sparkle sparkle = new Sparkle();
  //sparkle.setClearOnDisplay(true);
  sparkle.nDots = 100;
  canvas.add(sparkle);
}

void draw() {
  background(0);
  stroke(255);
//  line(random(width), random(height), random(width), random(height));
  line(0, 0, width, height);
  canvas.update();
  canvas.display();

  
  println(frameRate);
}
