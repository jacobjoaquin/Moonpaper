package moonpaper;

import java.util.ArrayList;

import moonpaper.opcodes.*;
import processing.core.PApplet;

public class Controller {
	private PApplet parent;
	public ArrayList<Canvas> canvases;
	public ArrayList<Opcode> opcodes;
	public int currentOpcode = 0;

	public Controller(PApplet pApplet_) {
		parent = pApplet_;
		canvases = new ArrayList<Canvas>();
		opcodes = new ArrayList<Opcode>();
	}

	public Canvas createCanvas() {
		Canvas canvas = new Canvas(parent);
		canvases.add(canvas);
		return canvas;
	}

	public Canvas createCanvas(int width, int height) {
		Canvas canvas = new Canvas(parent, width, height);
		canvases.add(canvas);
		return canvas;
	}

	public void update() {
		for (Canvas canvas : canvases) {
			canvas.update();
		}

		if (opcodes.size() >= 1) {
			Opcode o = opcodes.get(currentOpcode);
			o.exec();
		}
	}

	public void display() {
		for (Canvas canvas : canvases) {
			canvas.display();
		}
	}

	public ArrayList<Canvas> getCanvases() {
		return canvases;
	}

	public void nextOpcode() {
		Opcode o = opcodes.get(currentOpcode);
		o.cleanup();
		currentOpcode = (currentOpcode + 1) % opcodes.size();
		o = opcodes.get(currentOpcode);
		o.init();
	}

	public void addOpcode(Opcode opcode) {
		opcode.setController(this);
		opcodes.add(opcode);
	}

	public void flipActive() {
		FlipActive flipActive = new FlipActive();
		flipActive.setController(this);
		opcodes.add(flipActive);
	}
	
	public void wait(int nFrames) {
		Wait w = new Wait(nFrames);
		w.setController(this);
		opcodes.add(w);
	}
}