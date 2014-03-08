class Bouncy extends Displayable {
  PVector location;
  PVector velocity;
  float radius;
  
  Bouncy(PVector l, PVector v, float r) {
    location = l;
    velocity = v;
    radius = r;
  }
  
  void display() {
    fill(255);
    stroke(0);
    ellipse(location.x, location.y, radius * 2, radius * 2);
  }
  
  void update() {
    location.add(velocity);

    float offset = radius;
    float boundryRight = width - 1 - offset;
    float boundryBottom = height - 1 - offset;

    if (location.x < offset) {
      location.x = offset;
      velocity.x *= -1;
    }

    if (location.x > boundryRight) {
      location.x = boundryRight;
      velocity.x *= -1;
    }

    if (location.y < offset) {
      location.y = offset;
      velocity.y *= -1;
    }

    if (location.y > boundryRight) {
      location.y = boundryRight;
      velocity.y *= -1;
    }
  }
}

