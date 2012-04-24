package api.configuration;


import java.util.ArrayList;
/**
 * @author Ran Zhang
 */
public abstract class KeySubject {

	public ArrayList<Object> observers = new ArrayList<Object>();

	/**
	 * Register observers to this subject
	 */
	public void registerObserver(Object o) {
		observers.add(o);
	}

	/**
	 * remove specified observers 
	 */
	public void removeObserver(Object o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

}
