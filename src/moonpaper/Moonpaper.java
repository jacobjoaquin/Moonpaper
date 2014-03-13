package moonpaper;

import java.util.ArrayList;
import java.util.Iterator;

import moonpaper.opcodes.*;
import processing.core.PApplet;

public final class Moonpaper {
	public final static String VERSION = "##library.prettyVersion##";
	private PApplet parent;
	private ArrayList<Canvas> canvases;
	private MoonCodeInterpreter interpreter;

	public Moonpaper(PApplet pApplet_) {
		parent = pApplet_;
		canvases = new ArrayList<Canvas>();
		interpreter = new MoonCodeInterpreter(this);
	}

	/**
	 * Return the version of the library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}

	public Canvas createCanvas() {
		Canvas canvas = new Canvas(parent);
		canvases.add(canvas);
		return canvas;
	}

	public Canvas createCanvas(int width, int height) {
		Canvas canvas = new Canvas(parent, width, height);
		// TODO: Should this automatically add canvas?
		canvases.add(canvas);
		return canvas;
	}

	public void display() {
		for (Canvas canvas : canvases) {
			canvas.display();
		}
	}

	public Iterator<Canvas> getCanvasesIterator() {
		return canvases.iterator();
	}

	public void seq(MoonCode mooncode) {
		interpreter.add(mooncode);
	}

	public void update() {
		interpreter.update();
		for (Canvas canvas : canvases) {
			canvas.update();
		}
	}
	
	public void debugMe(String s, Object o) {
		String oName = o.getClass().getName();
		PApplet.println(s + ": " + oName);
	}
}