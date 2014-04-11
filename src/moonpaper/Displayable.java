package moonpaper;

import processing.core.PApplet;
import processing.core.PGraphics;

public abstract class Displayable {
//	protected StackPGraphics stackPG;
	private int blendMode = PApplet.BLEND;
	protected PGraphics pg;
//	private Patchable<Integer> theTint = new Patchable<Integer>(255);;

	public void init() {
	};

	public Displayable() {
	};

	public void update() {
	};

	public void display() {
	}

	public final void setBlendMode(int blendMode_) {
		blendMode = blendMode_;
	}

	public final int getBlendMode() {
		return blendMode;
	}

	public final void setPGraphics(PGraphics pg_) {
		pg = pg_;
	}
	
	public final void setStackPGraphics(StackPGraphics stackPG_) {
//		stackPG = stackPG_;
	}
	
//	public final Patchable<Integer> getTint() {
//		return theTint;
//	}
//	
//	public final void setTint(int t) {
//		theTint = new Patchable<Integer>(t);
//	}
}