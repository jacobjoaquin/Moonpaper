import moonpaper.*;

Foo foo = new Foo();

class Foo extends Displayable {
  void display() {
    ellipse(width / 2, height / 2, 20, 20);
  }
}

void setup() {
  size(500, 500);
}

void draw() {
  foo.display();
}
