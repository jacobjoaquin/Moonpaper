package moonpaper.opcodes;

import moonpaper.Patchable;
import processing.core.PApplet;

public class Line extends UnitGenerator {
	float start;
	float end;
	int nFrames;
	int counter;
	public Patchable<Float> value;

	public Line(int nFrames_, float start_, float end_) {
		nFrames = nFrames_;
		start = start_;
		end = end_;
		value = new Patchable<Float>(start_);
	}

	public Line(int nFrames_, Patchable<Float> pf, float end_) {
		nFrames = nFrames_;
		start = pf.value();
		end = end_;
		value = pf;
	}


	@Override
	public void init() {
		super.init();
		counter = nFrames;
	}

	@Override
	public void exec() {
		counter--;
		float amount = (float) counter / (float) nFrames;
		value.set(end + (start - end) * amount);
		PApplet.println(value.value());
		if (counter <= 0) {
			release();
		}
	}
}
