import moonpaper.*;

int nCircles = 12;
int circleSize = 125;
Canvas canvas;

void setup() {
  size(500, 500);
  canvas = new Canvas(this, width, height);
  
  for (int i = 0; i < nCircles; i++) {
    float angle = random(TWO_PI);;
    Bouncy b = new Bouncy(new PVector(width / 2, height / 2), PVector.fromAngle(angle), circleSize);
    b.setBlendMode(DIFFERENCE);
    canvas.add(b);
  }
  
  canvas.add(new Mirror());
}

void draw() {
  background(0);
  canvas.update();
  canvas.display();
  println(frameRate);
}
