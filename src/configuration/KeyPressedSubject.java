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

	public void notifyObservers(long elapsedTime) {
		for (int i = 0; i < observers.size(); i++) {
			KeyPressedObserver observer = (KeyPressedObserver) observers.get(i);
			observer.pressKey(elapsedTime);
		}
	}
	
	public void notifyObservers(long elapsedTime, Object object) {
		for (int i = 0; i < observers.size(); i++) {
			KeyPressedObserver observer = (KeyPressedObserver) observers.get(i);
			if (observer.getObject().getClass().equals(object.getClass()))
				observer.pressKey(elapsedTime);
		}
	}

}
