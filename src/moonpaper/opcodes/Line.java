package moonpaper.opcodes;

import processing.core.PApplet;

public class Line extends UnitGenerator {
	int nFrames;

	@Override
	public void init() {
		super.init();
		nFrames = 5;
	}
	
	@Override
	public void exec() {
		nFrames--;
		PApplet.println("Line frame: " + nFrames);
		if (nFrames <= 0) {
			release();
		}
	}
}