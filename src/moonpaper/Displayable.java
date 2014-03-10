package moonpaper;

import processing.core.PApplet;

public class Displayable {
	protected StackPGraphics stackPG;
	private int blendMode = PApplet.BLEND;

	public void init() {
	};

	public Displayable() {
	};

	public void update() {
	};

	public void display() {
	}

	public void setBlendMode(int blendMode_) {
		blendMode = blendMode_;
	}

	public int getBlendMode() {
		return blendMode;
	}

	public void setStackPGraphics(StackPGraphics stackPG_) {
		stackPG = stackPG_;
	}
}