class Mirror extends Displayable {
  void display() {
    int halfWidth = pg.width / 2;
    int wMinus1 = pg.height - 1;
    
    pg.loadPixels();
    for (int i = 0; i < halfWidth; i++) {
      for (int j = 0; j < pg.height; j++) {
        int offset = j * pg.width;
        pg.pixels[wMinus1 - i + offset] = pg.pixels[i + offset];
      }
    }
    pg.updatePixels();    
  }
}
