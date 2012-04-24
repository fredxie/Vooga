package configuration.api;

/**
 * @author Ran Zhang
 */

public class KeyChangedSubject extends KeySubject {

	public static final KeyChangedSubject keyChanged = new KeyChangedSubject();

	public static KeyChangedSubject getInstance() {
		return keyChanged;
	}

	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			KeyChangedObserver observer = (KeyChangedObserver) observers.get(i);
			observer.changeKey();
		}
	}
}
