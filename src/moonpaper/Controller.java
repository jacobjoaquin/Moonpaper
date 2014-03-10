package moonpaper;

import java.util.ArrayList;
import processing.core.*;

public class Controller {
	private PApplet parent;
	ArrayList<Canvas> canvases;
	
	public Controller(PApplet pApplet_) {
		parent = pApplet_;
		canvases = new ArrayList<Canvas>();
	}
	
	public Canvas createCanvas(int w, int h) {
		Canvas canvas = new Canvas(parent, w, h);
		canvases.add(canvas);
		return canvas;
	}
	
	public void update() {
		for (Canvas canvas : canvases) {
			canvas.update();
		}
	}
}