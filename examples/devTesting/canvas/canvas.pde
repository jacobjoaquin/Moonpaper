import moonpaper.*;

int nCircles = 16;
int circleSize = 64;
Canvas canvas;

void setup() {
  size(500, 500);
  canvas = new Canvas(this, width, height);
  
  for (int i = 0; i < nCircles; i++) {
    float angle = map(i, 0, nCircles, 0, TWO_PI);
    Bouncy b = new Bouncy(new PVector(width / 2, height / 2), PVector.fromAngle(angle), circleSize);
    b.blendMode(DIFFERENCE);
    canvas.add(b);
  }
}

void draw() {
  background(0);
  canvas.update();
  canvas.display();
  println(frameRate);
}
