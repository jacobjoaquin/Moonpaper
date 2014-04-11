package moonpaper;

import java.util.ArrayList;

import processing.core.PGraphics;
import processing.core.PApplet;

public class Cel extends Displayable implements Runnable {
	public PGraphics pg;
	private ArrayList<Displayable> displayables;
	private PApplet papplet;
//	private StackPGraphics stackPG;
	private boolean isActiveState = true;
	private Patchable<Float> transparency = new Patchable<Float>(255.0f);

	public Cel(PApplet parent_) {
		papplet = parent_;
		pg = papplet.createGraphics(papplet.width, papplet.height, PApplet.P2D);
//		PApplet.println(papplet.width);
//		stackPG = new StackPGraphics(papplet);
		displayables = new ArrayList<Displayable>();
	}

	public Cel(PApplet parent_, int width, int height) {
		papplet = parent_;
		pg = papplet.createGraphics(width, height, PApplet.P2D);
//		stackPG = new StackPGraphics(papplet);
		displayables = new ArrayList<Displayable>();
	}

	public void run() {
		update();
	}
	
	@Override
	public void update() {
		if (isActiveState) {
			PGraphics pgx = papplet.createGraphics(500, 500, PApplet.P2D);
			PApplet.println("update: " + papplet.width);
			PApplet.println("pgx: " + pgx.width);
			pgx.beginDraw();
//			pg.clear();
//			for (Displayable d : displayables) {
//				d.update();
//
//				// TODO: I don't like this. Do something about it.
//				if (d instanceof Filter) {
//					Filter f = (Filter) d;
//					if (f.getClearOnDisplay()) {
//						pg.clear();
//					}
//				}
//			}
			pgx.endDraw();
		}
	}

	@Override
	public void display() {
		if (isActiveState && transparency.value() >= 1.0) {
			pg.beginDraw();
			for (Displayable d : displayables) {
				pg.blendMode(d.getBlendMode());
				d.display();
				pg.blendMode(PApplet.BLEND);
			}
			pg.endDraw();
			if (transparency.value() <= 254.0) {
				papplet.tint(255, transparency.value());
			} else {
				papplet.noTint();
			}
			papplet.image(pg, 0, 0);
		}
	}

	public void add(Displayable d) {
		d.setPGraphics(pg);
		d.init();
		displayables.add(d);
	}

	public void removeLast() {
		int size = displayables.size(); 
		if (size > 0) {
			displayables.remove(size - 1);
		}
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

	public final Patchable<Float> getTransparency() {
		return transparency;
	}

	public final void setTransparency(float f) {
		transparency = new Patchable<Float>(f);
	}
}
