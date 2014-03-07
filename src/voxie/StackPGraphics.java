package voxie;

import processing.core.*;
import java.util.ArrayList;

public class StackPGraphics {
	private ArrayList<PGraphics> pgList;
	private ArrayList<PVector> dimensionsList;
	private PApplet pApplet;

	public StackPGraphics(PApplet p_) {
		pApplet = p_;
		pgList = new ArrayList<PGraphics>();
		dimensionsList = new ArrayList<PVector>();
	}
	
	StackPGraphics() {
		pgList = new ArrayList<PGraphics>();
		dimensionsList = new ArrayList<PVector>();
	}

	public PGraphics push() {
		return push(pApplet.createGraphics(pApplet.width, pApplet.height));
	}

	public PGraphics push(int w, int h) {
		return push(pApplet.createGraphics(w, h));
	}

/*
	public PGraphics push(int w, int h, String renderer) {
		PGraphics pg = pApplet.createGraphics(w, h, renderer);
		return push(pg);
	}
*/
	
	public PGraphics pushCopy() {
		PGraphics pgCopy = pApplet.createGraphics(pApplet.width, pApplet.height);
		pgCopy.copy(pApplet.g, 0, 0, pApplet.g.width, pApplet.g.height, 0, 0, pApplet.g.width, pApplet.g.height);
		return push(pgCopy);
	}

	public PGraphics push(PGraphics pg) {
		pgList.add(pApplet.g);
		dimensionsList.add(new PVector(pApplet.width, pApplet.height));
		pApplet.g = pg;
		pApplet.width = pg.width;
		pApplet.height = pg.height;
		pApplet.g.beginDraw();
		return pApplet.g;
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
	
//	public PGraphics pop(int blendMode) { }
}
