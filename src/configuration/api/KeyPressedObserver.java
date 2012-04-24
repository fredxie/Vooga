package configuration.api;

/**
 * @author Ran Zhang
 */
public interface KeyPressedObserver {

	public void pressKey(long elapsedTime);
	public Object getObject();
}
