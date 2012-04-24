package api.configuration;

/**
 * @author Ran Zhang
 */
public interface KeyChangedObserver {

	/**
	 * When this observer is notified, change key correspondingly.
	 * 
	 * 
	 */
	public void changeKey();
}
