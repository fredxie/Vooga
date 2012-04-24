package configuration.api;

/**
 * @author Ran Zhang
 */
import java.util.ArrayList;

public abstract class KeySubject {

	public ArrayList<Object> observers = new ArrayList<Object>();

	public void registerObserver(Object o) {
		observers.add(o);
		// System.out.println(1000);
	}

	public void removeObserver(Object o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	// public abstract void notifyObservers(long elapsedTime);
}
