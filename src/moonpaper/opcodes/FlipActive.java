package moonpaper.opcodes;

import java.util.ArrayList;
import moonpaper.Canvas;

public class FlipActive extends Opcode {
	public FlipActive() {
		super();
	}

	public void exec() {
		ArrayList<Canvas> canvases = controller.getCanvases();
		for (Canvas canvas : canvases) {
			canvas.setActive(!canvas.isActive());
		}
		controller.nextOpcode();
	}
}
