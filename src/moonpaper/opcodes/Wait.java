package moonpaper.opcodes;

import java.util.ArrayList;
import moonpaper.Canvas;
import processing.core.*;

public class Wait extends Opcode {
	private int nFrames;
	private int counter;

	public void init() {
		super.init();
		counter = nFrames;
	}
	
	public Wait(int nFrames_) {
		nFrames = nFrames_;
	}

	public void exec() {
		if (counter <= 0) {
			controller.nextOpcode();
		}
		counter--;
	}
}
