package api.configuration;

/**
 * @author Ran Zhang
 */

public class KeyPressedSubject extends KeySubject {
	
	// Singleton pattern 
	public static final KeyPressedSubject keyPressed = new KeyPressedSubject();

	/**
	 * 
	 * 
	 * @return the instance
	 */
	public static KeyPressedSubject getInstance() {
		return keyPressed;
	}

	/**
	 * 
	 * If a key is pressed, then notify observers registered
	 */
	public void notifyObservers(long elapsedTime, Object object) {
		for (int i = 0; i < observers.size(); i++) {
			KeyPressedObserver observer = (KeyPressedObserver) observers.get(i);
			if (observer.getObject().getClass().equals(object.getClass()))
				observer.pressKey(elapsedTime);
		}
	}

}
