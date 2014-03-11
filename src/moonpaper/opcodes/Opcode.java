package moonpaper.opcodes;

import moonpaper.Controller;

// public class Process extends Opcode is the way to go.

public class Opcode {
	Controller controller;
	public boolean isInitialized = false;
	protected boolean releaseState = true;

	public Opcode() {
	}

	public void exec() {
	}

	public void init() {
		isInitialized = true;
	}

	public void cleanup() {
		isInitialized = false;
	}

	public void setController(Controller controller_) {
		controller = controller_;
	}

	protected final void hold() {
		releaseState = false;
	}

	protected final void release() {
		releaseState = true;
	}

	public final boolean getRelease() {
		return releaseState;
	}
}