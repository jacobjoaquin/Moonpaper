package moonpaper;

import java.util.ArrayList;
import java.util.Iterator;

import moonpaper.opcodes.*;
import processing.core.PApplet;

public class Controller {
	public PApplet parent;
	public ArrayList<Canvas> canvases;
	public ArrayList<Opcode> opcodes;
	public ArrayList<UnitGenerator> ugens;
	public int currentOpcode = 0;

	public Controller(PApplet pApplet_) {
		parent = pApplet_;
		canvases = new ArrayList<Canvas>();
		opcodes = new ArrayList<Opcode>();
		ugens = new ArrayList<UnitGenerator>();
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

	public void display() {
		for (Canvas canvas : canvases) {
			canvas.display();
		}
	}

	public Iterator<Canvas> getCanvasesIterator() {
		return canvases.iterator();
	}

	private void nextOpcode() {
		Opcode o = opcodes.get(currentOpcode);
		o.cleanup();
		currentOpcode = (currentOpcode + 1) % opcodes.size();
		o = opcodes.get(currentOpcode);
		o.init();
	}

	public void seq(Opcode opcode) {
		opcode.setController(this);
		opcodes.add(opcode);
	}

	public void update() {
		updateUnitGenerators();
		for (Canvas canvas : canvases) {
			canvas.update();
		}
		updateOpcodes();
	}

	public void updateOpcodes() {
		if (opcodes.size() >= 1) {
			while (true) {
				Opcode o = opcodes.get(currentOpcode);
				o.exec();

				if (o.getRelease()) {
					nextOpcode();
				} else {
					if (o instanceof UnitGenerator) {
						ugens.add((UnitGenerator) o);
						nextOpcode();
					} else {
						break;
					}
				}
			}
		}
	}

	public void updateUnitGenerators() {
		Iterator<UnitGenerator> i = ugens.iterator();
		while (i.hasNext()) {
			UnitGenerator ugen = i.next();
			ugen.exec();
			if (ugen.getRelease()) {
				i.remove();
			}
		}
	}
}