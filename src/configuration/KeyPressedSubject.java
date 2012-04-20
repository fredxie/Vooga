package configuration;

/**
 * @author Ran Zhang
 */
import java.util.ArrayList;

public class KeyPressedSubject extends KeySubject {
	public static final KeyPressedSubject keyPressed = new KeyPressedSubject();

	public static KeyPressedSubject getInstance() {
		return keyPressed;
	}

	// private static ArrayList<KeyPressedObserver> observers = new
	// ArrayList<KeyPressedObserver>();
	//
	//
	// public KeyPressedSubject() {
	// observers = new ArrayList<KeyPressedObserver>();
	// }
	//
	// public static void registerObserver(KeyPressedObserver o) {
	// observers.add(o);
	// // System.out.println(1000);
	// }
	//
	// public void removeObserver(KeyPressedObserver o) {
	// int i = observers.indexOf(o);
	// if (i >= 0) {
	// observers.remove(i);
	// }
	// }

	// observers = new ArrayList<KeyPressedObserver>();

	public void notifyObservers(long elapsedTime) {
		for (int i = 0; i < observers.size(); i++) {
			KeyPressedObserver observer = (KeyPressedObserver) observers.get(i);
			observer.pressKey(elapsedTime);
		}
	}

}
