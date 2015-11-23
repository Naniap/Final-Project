/**
 * A simple callback wrapper that provides Javascript-like anonymous callback functions.
 * @param <T> The passed parameter type.
 */
public abstract class Callback<T> {
	/**
	 * The method to call once the action is complete.
	 */
	public abstract void call(T param);
}
