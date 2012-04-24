package api.configuration;

/**
 * @author Ran Zhang
 */
public class KeyChangedSubject extends KeySubject {

	// Singleton pattern 
	public static final KeyChangedSubject keyChanged = new KeyChangedSubject();

	/**
	 * 
	 * 
	 * @return the instance
	 */
	public static KeyChangedSubject getInstance() {
		return keyChanged;
	}

	/**
	 * 
	 * If a key is changed, then notify observers registered
	 */
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			KeyChangedObserver observer = (KeyChangedObserver) observers.get(i);
			observer.changeKey();
		}
	}
}
