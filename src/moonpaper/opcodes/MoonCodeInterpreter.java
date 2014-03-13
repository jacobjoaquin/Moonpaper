package moonpaper.opcodes;

import java.util.ArrayList;
import java.util.Iterator;
import moonpaper.Moonpaper;

public final class MoonCodeInterpreter {
	private Moonpaper controller;
	private ArrayList<MoonCode> mooncodes;
	private ArrayList<MoonCodeGenerator> generators;
	private int index;

	public MoonCodeInterpreter(Moonpaper controller_) {
		controller = controller_;
		mooncodes = new ArrayList<>();
		generators = new ArrayList<>();
	}

	public void add(MoonCode mooncode) {
		mooncode.setInterpreter(this);
		mooncode.setController(controller);
		mooncodes.add(mooncode);
	}

	private void next() {
		MoonCode mooncode = mooncodes.get(index);
		mooncode.cleanup();
		index = (index + 1) % mooncodes.size();
		mooncode = mooncodes.get(index);
		mooncode.init();
	}

	public void update() {
		updateGenerators();
		updateMoonCode();
	}

	private void updateMoonCode() {
		if (mooncodes.size() >= 1) {
			while (true) {
				MoonCode mooncode = mooncodes.get(index);
				mooncode.exec();

				if (mooncode.getRelease()) {
					next();
				} else {
					if (mooncode instanceof MoonCodeGenerator) {
						generators.add((MoonCodeGenerator) mooncode);
						next();
					} else {
						break;
					}
				}
			}
		}
	}

	private void updateGenerators() {
		Iterator<MoonCodeGenerator> i = generators.iterator();
		while (i.hasNext()) {
			MoonCodeGenerator generators = i.next();
			generators.exec();
			if (generators.getRelease()) {
				i.remove();
			}
		}
	}
}
