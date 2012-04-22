package configuration;

/**
 * @author Ran Zhang
 */


public class SystemKeyPressedObserver implements KeyPressedObserver {

	private KeyConfig Object;

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
		this.Object = Object;
		KeyPressedSubject.getInstance().registerObserver(this);
	}

	@Override
	public void pressKey(long elapsedTime) {
		// TODO Auto-generated method stub
		for (Key key : Object.getKeyList()) {
			if (key.isKeyPressed()) {
				key.executeKeyFuction(elapsedTime);
			}
		}
	}
}
