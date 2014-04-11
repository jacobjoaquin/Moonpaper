PImage makeDot(float size, float blurAmount, color c) {
  int pgSize = (int) ceil(size) * 2;
//  PGraphics pg = stackpg.push(pgSize, pgSize);
  PGraphics pg = createGraphics(pgSize, pgSize);
  pg.beginDraw();
  PVector center = new PVector(pg.width / 2, pg.height / 2);
  float ratio = size / 100.0;
  float step = size / 3;
  blurAmount *= ratio;
  color c2 = color(255);
    
  pg.background(0);
  for (float i = size; i >= 1; i -= step) {
    float n = pow(i / size, 2);
    color thisColor = lerpColor(c, c2, 1 - n);
//    stackpg.push();
    PGraphics pgTemp = createGraphics(pg.width, pg.height);
    pgTemp.beginDraw();
    pgTemp.smooth();
    pgTemp.noStroke();
    pgTemp.fill(thisColor);
    pgTemp.ellipse(center.x, center.y, i, i);
    pgTemp.endDraw();
//    stackpg.pop(BLEND);
//    pg.image(pgTemp, 0, 0);
//    image(pgTemp, 0, 0);
//    pg.blendMode(BLEND);
    pg.image(pgTemp, 0, 0);
//    pg.copy(pgTemp, 0, 0, width, height, 0, 0, width, height);
    pg.filter(BLUR, blurAmount);
//    pg.filter(BLUR, 1);
  }
//  return;

  // Get edge
  pg.loadPixels();
  int y = (pg.height / 2) * pg.width;
  int l0 = 0;
  int l1 = pg.width / 2;
  int l3 = 0;
  int counter = 100;
  int p = 255;
  
  while(l1 - l0 > 1 || p > 1) {
    l3 = (l1 - l0 ) / 2 + l0;    
    p = (int) brightness(pg.pixels[l3 + y]);
    if (p <= 1) {
      l0 = l3;
    }
    else {
      l1 = l3;
    }
  }
  pg.updatePixels();
  pg.endDraw();
//  stackpg.pop();

  // Generate and return cropped image  
  int imgSize = (int) ((center.x - l3) * 2);
  PImage img = createImage(imgSize, imgSize, ARGB);
  img.copy(pg, l3, l3, imgSize, imgSize, 0, 0, imgSize, imgSize);
  image(img, 0, 0);
  return img;
}

