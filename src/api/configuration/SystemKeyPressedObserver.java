package api.configuration;

/**
 * @author Ran Zhang
 */

public class SystemKeyPressedObserver implements KeyPressedObserver {

	private KeyConfig object;

	public SystemKeyPressedObserver(KeyConfig Object) {
		this.object = Object;
		KeyPressedSubject.getInstance().registerObserver(this);
	}

	@Override
	public void pressKey(long elapsedTime) {
		for (Key key : object.getKeyList()) {
			if (key.isKeyPressed()) {
				key.executeKeyFuction(elapsedTime);
			}
		}
	}

	@Override
	public Object getObject() {
		return object;
	}

}
