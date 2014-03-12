package moonpaper;

import java.util.ArrayList;
import processing.core.PGraphics;
import processing.core.PApplet;

public class Canvas extends Displayable {
	public PGraphics pg;
	private ArrayList<Displayable> displayables;
	private PApplet parent;
	private StackPGraphics stackPG;
	private boolean isActiveState = true;

	public Canvas(PApplet parent_) {
		parent = parent_;
		pg = parent.createGraphics(parent.width, parent.height);
		stackPG = new StackPGraphics(parent);
		displayables = new ArrayList<Displayable>();
	}

	public Canvas(PApplet parent_, int width, int height) {
		parent = parent_;
		pg = parent.createGraphics(width, height);
		stackPG = new StackPGraphics(parent);
		displayables = new ArrayList<Displayable>();
	}

	@Override
	public void update() {
		if (isActiveState) {
			pg.clear();
			stackPG.push(pg);
			for (Displayable d : displayables) {
				parent.blendMode(d.getBlendMode());
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
			pg.clear();
			stackPG.push(pg);
			for (Displayable d : displayables) {
				parent.blendMode(d.getBlendMode());
				d.display();
			}
			stackPG.pop();
			parent.image(pg, 0, 0);
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
