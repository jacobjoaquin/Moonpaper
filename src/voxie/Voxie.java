package voxie;

import processing.core.*;
import voxie.StackPGraphics;

public class Voxie {
	private PApplet p;
	
	public Voxie(PApplet parent) {
		p = parent;
	}

	public StackPGraphics createStackPGraphics() {
		return new StackPGraphics(p);
	}
}
