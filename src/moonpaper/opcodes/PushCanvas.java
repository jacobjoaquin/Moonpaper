package moonpaper.opcodes;

import moonpaper.Canvas;
import moonpaper.Displayable;

public class PushCanvas extends Opcode {
	private Displayable displayable;
	private Canvas canvas;

	public PushCanvas(Canvas canvas_, Displayable displayable_) {
		super();
		canvas = canvas_;
		displayable = displayable_;
	}

	public void exec() {
		canvas.add(displayable);
		controller.nextOpcode();
	}
}
