package moonpaper;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PVector;
import java.util.ArrayList;

public class StackPGraphics {
	private ArrayList<PGraphics> pgList;
	private ArrayList<PVector> dimensionsList;
	private PApplet pApplet;

	public StackPGraphics(PApplet p_) {
		pApplet = p_;
		pgList = new ArrayList<>();
		dimensionsList = new ArrayList<>();
	}

	StackPGraphics() {
		pgList = new ArrayList<>();
		dimensionsList = new ArrayList<>();
	}

	public PGraphics get() {
		return pApplet.g;
	}

	/**
	 * Creates and returns copy of current PGraphics in stack.
	 * 
	 * @return PGraphics
	 */
	public PGraphics copy() {
		PGraphics pgCopy = pApplet
				.createGraphics(pApplet.width, pApplet.height);
		pgCopy.copy(pApplet.g, 0, 0, pApplet.g.width, pApplet.g.height, 0, 0,
				pApplet.g.width, pApplet.g.height);
		return pgCopy;
	}

	public PGraphics push() {
		return push(pApplet.createGraphics(pApplet.width, pApplet.height));
	}

	public PGraphics push(int w, int h) {
		return push(pApplet.createGraphics(w, h));
	}

	/*
	 * public PGraphics push(int w, int h, String renderer) { PGraphics pg =
	 * pApplet.createGraphics(w, h, renderer); return push(pg); }
	 */

	public PGraphics push(PGraphics pg) {
		pgList.add(pApplet.g);
		dimensionsList.add(new PVector(pApplet.width, pApplet.height));
		pApplet.g = pg;
		pApplet.width = pg.width;
		pApplet.height = pg.height;
		pApplet.g.beginDraw();
		return pApplet.g;
	}

	public PGraphics pushCopy() {
		PGraphics pgCopy = pApplet
				.createGraphics(pApplet.width, pApplet.height);
		pgCopy.copy(pApplet.g, 0, 0, pApplet.g.width, pApplet.g.height, 0, 0,
				pApplet.g.width, pApplet.g.height);
		return push(pgCopy);
	}

	public PGraphics pushCopy(PGraphics pg) {
		PGraphics pgCopy = pApplet.createGraphics(pg.width, pg.height);
		pgCopy.copy(pg, 0, 0, pg.width, pg.height, 0, 0, pg.width, pg.height);
		return push(pgCopy);
	}

	public PGraphics pop() {
		pApplet.g.endDraw();
		PGraphics pgReturn = pApplet.g;
		pApplet.g = pgList.remove(pgList.size() - 1);
		PVector d = dimensionsList.remove(dimensionsList.size() - 1);
		pApplet.width = (int) d.x;
		pApplet.height = (int) d.y;
		return pgReturn;
	}

	public PGraphics pop(int blendMode) {
		pApplet.g.endDraw();
		PGraphics pgReturn = pApplet.g;
		pApplet.g = pgList.remove(pgList.size() - 1);
		PVector d = dimensionsList.remove(dimensionsList.size() - 1);
		pApplet.width = (int) d.x;
		pApplet.height = (int) d.y;
		int blendTemp = PApplet.BLEND;
		pApplet.blendMode(blendMode);
		pApplet.image(pgReturn, 0, 0);
		pApplet.blendMode(blendTemp);
		return pgReturn;
	}
}
