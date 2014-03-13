package moonpaper.opcodes;

import java.util.Iterator;

import moonpaper.Canvas;

public class ClearCanvases extends MoonCodeEvent {
	@Override
	public void exec() {
		Iterator<Canvas> iterator = controller.getCanvasesIterator();
		while (iterator.hasNext()) {
			Canvas canvas = iterator.next();
			canvas.clear();
		}
	}
}
