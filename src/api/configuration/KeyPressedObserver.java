package api.configuration;

/**
 * @author Ran Zhang
 */
public interface KeyPressedObserver {

	/**
	 * When this observer is notified, call the press key methods correspondingly.
	 * 
	 * 
	 */
	public void pressKey(long elapsedTime);

	/**
	 * 
	 * 
	 * @return the object that this observer is initiated in
	 */
	public Object getObject();
}
