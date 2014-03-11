package moonpaper.opcodes;

import java.util.Iterator;
import moonpaper.Canvas;

public class FlipActive extends Opcode {
	public FlipActive() {
		super();
	}

	@Override
	public void exec() {
		Iterator<Canvas> iterator = controller.getCanvasesIterator();
		while (iterator.hasNext()) {
			Canvas canvas = iterator.next();
			canvas.setActive(!canvas.isActive());
		}
	}
}
