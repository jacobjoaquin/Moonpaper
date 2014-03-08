package moonpaper;

import processing.core.*;

/*
 * This is the controller for most everything.
 */
public class MoonPaper {
	public final static String VERSION = "##library.prettyVersion##";
	private PApplet pApplet;
	private StackPGraphics stackPG;
	
	public MoonPaper(PApplet parent) {
		pApplet = parent;
		stackPG = new StackPGraphics(pApplet);
	}

	/**
	 * Return the version of the library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}
	
	
	/*
	public Layer createLayer() { }	
	public void push(Routine r) { }	
	*/

	public void update() {
		// Update all layers
	}
}

