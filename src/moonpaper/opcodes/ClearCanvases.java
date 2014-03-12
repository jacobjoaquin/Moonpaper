package moonpaper.opcodes;

import moonpaper.Canvas;

public class ClearCanvases extends Opcode {
	@Override
	public void exec() {
		for (Canvas canvas : controller.canvases) {
			canvas.clear();
		}
	}
}
