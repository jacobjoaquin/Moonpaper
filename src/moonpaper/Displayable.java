package moonpaper;

import processing.core.*;

public class Displayable {
	protected StackPGraphics stackPG;
	private int blendMode = PApplet.BLEND;
	//private boolean clearDisplay = false;
	
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
	/*
	public void setClearOnDisplay(boolean clearDisplay_) {
		clearDisplay = clearDisplay_;
	}
	
	public boolean getClearOnDisplay() {
		return clearDisplay;
	}
	*/
}