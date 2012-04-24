package api.configuration;

/**
 * @author Ran Zhang
 */
public interface KeyPressedObserver {

	public void pressKey(long elapsedTime);

	public Object getObject();
}
