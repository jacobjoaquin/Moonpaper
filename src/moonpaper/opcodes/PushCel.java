package moonpaper.opcodes;

import processing.core.PApplet;
import moonpaper.Cel;
import moonpaper.Displayable;

public class PushCel extends MoonCodeEvent {
	private Displayable displayable;
	private Cel cel;

	public PushCel(Cel cel_, Displayable displayable_) {
		super();
		cel = cel_;
		displayable = displayable_;
	}

	@Override
	public void exec() {
		PApplet.println("PushCanvas.exec()");
		cel.add(displayable);
	}
}
