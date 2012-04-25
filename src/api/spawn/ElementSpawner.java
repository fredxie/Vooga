package api.spawn;

import java.util.ArrayList;
import java.util.List;

import api.element.Element;


/**
 * 
 * @author Gang Song
 * @Description This class is mainly for creating a group of elements It is
 *              implemented by Strategy pattern and Generics
 * 
 */

public class ElementSpawner<E extends Element> {

	private SpawnBehavior mySpawnBehavior;
	private E myElement;
	private int myElementNum;

	/**
	 * @param element
	 *            is the type of the element that is going to be spawned
	 * @param
	 */
	public ElementSpawner(SpawnBehavior sb, E element, int elementNum) {

		myElementNum = elementNum;
		mySpawnBehavior = sb;
		myElement = element;
	}

	/**
	 * 
	 * @return a list of Element E
	 */
	public List<E> spawn() {

		List<E> elements = new ArrayList<E>();

		if (mySpawnBehavior.checkIfSpawn()) {

			for (int i = 0; i < myElementNum; i++) {

				E currentElement = (E) myElement.clone();// To clone the same
															// kind of element
//				currentElement.setSpawnBehavior(mySpawnBehavior);
				currentElement.spawn(mySpawnBehavior);
				// currentElement
				elements.add(currentElement);
			}

		}
		return elements;

	}

	/**
	 * @param sb
	 *            : change spawning behavior to sb
	 */
	public void setSpawnBehavior(SpawnBehavior sb) {
		mySpawnBehavior = sb;
	}

	/**
	 * @param enemy
	 *            : change Element sub-type to element
	 */
	public void setElement(E element) {
		myElement = element;
	}

	public void setElementNum(int num) {
		myElementNum = num;
	}

}
