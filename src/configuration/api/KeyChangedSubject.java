package configuration.api;

/**
 * @author Ran Zhang
 */
import java.util.ArrayList;

public class KeyChangedSubject extends KeySubject {

	public static final KeyChangedSubject keyChanged = new KeyChangedSubject();

	public static KeyChangedSubject getInstance() {
		return keyChanged;
	}

	// private static ArrayList<KeyChangedObserver> observers = new
	// ArrayList<KeyChangedObserver>();
	//
	//
	// public KeyChangedSubject() {
	// observers = new ArrayList<KeyChangedObserver>();
	// }
	//
	// public static void registerObserver(KeyChangedObserver o) {
	// observers.add(o);
	// // System.out.println(1000);
	// }
	//
	// public void removeObserver(KeyChangedObserver o) {
	// int i = observers.indexOf(o);
	// if (i >= 0) {
	// observers.remove(i);
	// }
	// }

	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			KeyChangedObserver observer = (KeyChangedObserver) observers.get(i);
			observer.changeKey();
		}
	}
}
