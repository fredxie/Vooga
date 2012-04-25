package api.configuration;

/**
 * Observer to observe the system key changed events.
 * 
 * 
 * @author Ran Zhang
 */
public class SystemKeyPressedObserver implements KeyPressedObserver {

	private KeyConfig object;

	public SystemKeyPressedObserver(KeyConfig Object) {
		this.object = Object;
		KeyPressedSubject.getInstance().registerObserver(this);
	}

	/**
	 * When this observer is notified, iterate the key list to react to the
	 * pressed key.
	 * 
	 * 
	 * @return void
	 */
	public void pressKey(long elapsedTime) {
		for (Key key : object.getKeyList()) {
			if (key.isKeyPressed()) {
				key.executeKeyFuction(elapsedTime);
			}
		}
	}


	/**
	 * 
	 * 
	 * @return the object that this observer is initiated in
	 */
	public Object getObject() {
		return object;
	}

}
