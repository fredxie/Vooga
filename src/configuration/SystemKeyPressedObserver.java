package configuration;

/**
 * @author Ran Zhang
 */


public class SystemKeyPressedObserver implements KeyPressedObserver {

	private KeyConfig object;

	// private boolean active = false;
	//
	// public boolean isActive() {
	// return active;
	// }
	//
	// public void setActive(boolean active) {
	// this.active = active;
	// }

	public SystemKeyPressedObserver(KeyConfig Object) {
		this.object = Object;
		KeyPressedSubject.getInstance().registerObserver(this);
	}

	@Override
	public void pressKey(long elapsedTime) {
		// TODO Auto-generated method stub
		for (Key key : object.getKeyList()) {
			if (key.isKeyPressed()) {
				key.executeKeyFuction(elapsedTime);
			}
		}
	}

	@Override
	public Object getObject() {
		// TODO Auto-generated method stub
		return object;
	}
	
	
}
