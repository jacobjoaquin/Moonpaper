package moonpaper.opcodes;

import processing.core.PApplet;
import moonpaper.Canvas;
import moonpaper.Displayable;

public class PushCanvas extends MoonCodeEvent {
	private Displayable displayable;
	private Canvas canvas;

	public PushCanvas(Canvas canvas_, Displayable displayable_) {
		super();
		canvas = canvas_;
		displayable = displayable_;
	}

	@Override
	public void exec() {
		PApplet.println("PushCanvas.exec()");
		canvas.add(displayable);
	}
}
