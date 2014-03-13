package moonpaper;

import java.util.ArrayList;
import java.util.Iterator;

import moonpaper.opcodes.*;
import processing.core.PApplet;

public final class Moonpaper {
	public final static String VERSION = "##library.prettyVersion##";
	private PApplet parent;
	private ArrayList<Cel> cels;
	private MoonCodeInterpreter interpreter;

	public Moonpaper(PApplet pApplet_) {
		parent = pApplet_;
		cels = new ArrayList<>();
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

	public Cel createCel() {
		Cel cel = new Cel(parent);
		cels.add(cel);
		return cel;
	}

	public Cel createCel(int width, int height) {
		Cel cel = new Cel(parent, width, height);
		// TODO: Should this automatically add canvas?
		cels.add(cel);
		return cel;
	}

	public void display() {
		for (Cel c : cels) {
			c.display();
		}
	}

	public Iterator<Cel> getCelIterator() {
		return cels.iterator();
	}

	public void seq(MoonCode mooncode) {
		interpreter.add(mooncode);
	}

	public void update() {
		interpreter.update();
		for (Cel c : cels) {
			c.update();
		}
	}
	
	public void debugMe(String s, Object o) {
		String oName = o.getClass().getName();
		PApplet.println(s + ": " + oName);
	}
}