package moonpaper;

import java.util.ArrayList;
import processing.core.*;

public class Canvas extends Displayable {
	public PGraphics pg;
	private ArrayList<Displayable> displayables;
	private PApplet parent;
	private StackPGraphics stackPG;
	
	public Canvas(PApplet parent_, int w, int h) {
		parent = parent_;
		pg = parent.createGraphics(w, h);
		stackPG = new StackPGraphics(parent);
		displayables = new ArrayList<Displayable>();
	}
	
	public void update() {
		pg.clear();		
		stackPG.push(pg);
		for (Displayable d : displayables) {
			parent.blendMode(d.blendMode);
			d.update();
			d.display();
		}
		stackPG.pop();
	}
	
	public void display() {
		parent.image(pg, 0, 0);
	}
	
	public void add(Displayable d) {
		displayables.add(d);
	}
	
	public int getBlendMode() {
		return 1;
	}
}

