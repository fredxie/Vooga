package spawn;

import java.util.ArrayList;
import java.util.List;

import element.Element;

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

	// private PlayField myPlayField;

	/**
	 * @param element
	 *            is the type of the element that is going to be spawned
	 * @param
	 */
	public ElementSpawner(SpawnBehavior sb, E element, int enemyNum) {

		myElementNum = enemyNum;
		mySpawnBehavior = sb;
		myElement = element;
	}

	public List<E> spawn() {

		List<E> elements = new ArrayList<E>();

		if (mySpawnBehavior.check()) {

			for (int i = 0; i < myElementNum; i++) {

				E currentElement = (E) myElement.clone();// To clone the same
															// kind of element
				currentElement.setSpawnBehavior(mySpawnBehavior);
				currentElement.spawn();
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
	 *            : change Enemy type to enemy
	 */
	public void setElement(E element) {
		myElement = element;
	}

	public void setElementNum(int num) {
		myElementNum = num;
	}

	/**
	 * 
	 * @param elapsedTime
	 * @Description: This method is mainly used for time related spawning
	 *               behavior, such as SpawnByTime
	 */

	//
	// public Enemy[] refresh(long elapsedTime){
	// if(myTimer.action(elapsedTime)){
	// myTimer.refresh();
	// return spawn();
	// }
	// return null;
	// }
	//

	// public boolean refresh(long elapsedTime){
	// boolean state=myTimer.action(elapsedTime);
	// if(state){
	// myTimer.refresh();
	// }
	// return state;
	// }

	//
	// public void setTimer(Timer time){
	// myTimer=time;
	// }

	// public Enemy[] spawnByFighterState(){
	// if (hasSpawned == false) {
	//
	// Enemy[] retEne=spawn();
	// if(retEne!=null){
	// hasSpawned = true;
	// }
	// return retEne;
	// }
	// return null;
	// }
	//
	// public boolean checkSpawn(){
	// return hasSpawned;
	// }

}
