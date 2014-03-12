package moonpaper;

public final class Patchable<T> {
	public T value;

	public Patchable(T t) {
		value = t;
	}

	public void set(T t) {
		value = t;
	}

	public Patchable<T> get() {
		return new Patchable<T>(value);
	}

	public T value() {
		return value;
	}
}
