package moonpaper;

import java.util.ArrayList;
import java.util.Iterator;

import moonpaper.opcodes.*;
import processing.core.PApplet;

public final class Moonpaper {
	public final static String VERSION = "##library.prettyVersion##";
	private PApplet papplet;
	private ArrayList<Cel> cels;
	private MoonCodeInterpreter interpreter;

	// private boolean isRoot;

	public Moonpaper(PApplet pApplet_) {
		papplet = pApplet_;
		cels = new ArrayList<Cel>();
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
		Cel cel = new Cel(papplet);
		cels.add(cel);
		return cel;
	}

	public Cel createCel(int width, int height) {
		Cel cel = new Cel(papplet, width, height);
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

	public void seq(Moonpaper mp) {
		// The complex way.
		// Should act like a stack.
		// Master pointer is passed into this sub-moonpaper object.
		// All parent actions are paused / disabled. ???
		//
	}

	public void seqCopy(Moonpaper mp) {
		// The simple way.
		for (MoonCode mc : interpreter.getMoonCodes()) {
			interpreter.add(mc);
		}
	}

	public void update() {
		interpreter.update();
		// updateT();
		for (Cel c : cels) {
			c.update();
		}
	}

	private void updateT() {
		// FIXME: This implementation certainly doesn't work, but it something
		// like this could with the right graphing mechanisms in place.
		ArrayList<Thread> threads = new ArrayList<Thread>();

		for (Cel c : cels) {
			Thread celThread = new Thread(c);
			celThread.start();
			threads.add(celThread);
		}

		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
			}
		}
	}

	public void debugMe(String s, Object o) {
		String oName = o.getClass().getName();
		PApplet.println(s + ": " + oName);
	}
}