import voxie.*;

StackPGraphics spg;

void setup() {
  size(500, 500);
  smooth();
  noLoop();
  spg = new StackPGraphics(this);
}

void draw() {
  ellipse(width / 2, height / 2, 5, 5);
  
 // line(0, 0, width, height);
  PGraphics foo = spg.push(20, 300);
  line(width, 0, 0, height);
  spg.pop();
  image(foo, 0, 0);

  foo = spg.push(200, 500);
  line(width, 0, 0, height);
  spg.pop();
  image(foo, 0, 0);

  PGraphics bar = createGraphics(width, height);
  bar.beginDraw();
  bar.line(0, 0, bar.width, bar.height);
  bar.endDraw();
  image(bar, 0, 0);

  PGraphics baz = createGraphics(200, 200);
  baz.beginDraw();
  baz.line(baz.width, 0, 0, baz.height);
  baz.endDraw();
  image(baz, 0, 0);
  
  PGraphics c = spg.pushCopy();
  noFill();
  rect(50, 50, 100, 100);
  spg.pop();
  image(c, 0, 0);
  
}
