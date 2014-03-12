package moonpaper.opcodes;

import moonpaper.opcodes.Opcode;

public class UnitGenerator extends Opcode {
	@Override
	public void init() {
		super.init();
		hold();
	}
}
