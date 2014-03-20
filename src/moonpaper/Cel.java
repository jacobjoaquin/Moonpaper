package moonpaper;

import java.util.ArrayList;
import processing.core.PGraphics;
import processing.core.PApplet;

public class Cel extends Displayable {
	public PGraphics pg;
	private ArrayList<Displayable> displayables;
	private PApplet papplet;
	private StackPGraphics stackPG;
	private boolean isActiveState = true;

	public Cel(PApplet parent_) {
		papplet = parent_;
		pg = papplet.createGraphics(papplet.width, papplet.height);
		stackPG = new StackPGraphics(papplet);
		displayables = new ArrayList<Displayable>();
	}

	public Cel(PApplet parent_, int width, int height) {
		papplet = parent_;
		pg = papplet.createGraphics(width, height);
		stackPG = new StackPGraphics(papplet);
		displayables = new ArrayList<Displayable>();
	}

	@Override
	public void update() {
		if (isActiveState) {
			pg.clear();
			stackPG.push(pg);
			for (Displayable d : displayables) {
				d.update();

				// TODO: I don't like this. Do something about it.
				if (d instanceof Filter) {
					Filter f = (Filter) d;
					if (f.getClearOnDisplay()) {
						pg.clear();
					}
				}
			}
			stackPG.pop();
		}
	}

	@Override
	public void display() {
		if (isActiveState) {
			stackPG.push(pg);
			for (Displayable d : displayables) {
//				PApplet.println(papplet.frameCount + ", " + d);
				papplet.blendMode(d.getBlendMode());
				d.display();
				papplet.blendMode(PApplet.BLEND);
			}
			stackPG.pop(PApplet.BLEND);
		}
	}

	public void add(Displayable d) {
		stackPG.push(pg);
		d.setStackPGraphics(stackPG);
		d.init();
		stackPG.pop();
		displayables.add(d);
	}

	public void setActive(boolean isActiveState_) {
		isActiveState = isActiveState_;
	}

	public boolean isActive() {
		return isActiveState;
	}

	public void clear() {
		displayables.clear();
	}
}
