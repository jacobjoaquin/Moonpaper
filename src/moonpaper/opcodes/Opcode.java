package moonpaper.opcodes;

import moonpaper.Controller;

public class Opcode {
	Controller controller;
	public boolean isInitialized = false;
	public boolean onHold = false;

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

	public Opcode get() {
		return this;
	}

	public void setController(Controller controller_) {
		controller = controller_;
	}
	
	public void hold() {
		onHold = true;
	}
	
	public void release() {
		onHold = false;
	}
}