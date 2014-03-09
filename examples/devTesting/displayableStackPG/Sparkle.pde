class Sparkle extends Filter {
  int nDots = 1000;
  float threshold = 1.0;
  ArrayList<Integer> theDots;

  void init() {
    theDots = new ArrayList<Integer>(nDots);
  }
  
  void display() {
    loadPixels();
    for (Integer d : theDots) {
      pixels[d] = color(255);
    }
    updatePixels();
  }
  
  void update() {
    PGraphics pgBackground = stackPG.get();    
    PGraphics pg = stackPG.push();
    theDots.clear();
    pgBackground.loadPixels();
    loadPixels();
    for (int i = 0; i < nDots; i++) {
      int r = (int) random(width * height);
      if (threshold < brightness(pgBackground.pixels[r])) {
        theDots.add(new Integer(r));        
      } 
    }
    updatePixels();
    stackPG.pop();    
  }  
}

