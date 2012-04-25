/**
 * @author Gang Song
 */

package api.spawn;

public interface SpawnBehavior {

	/**
	 * Spawn (set the position) an element, return the element position
	 * 
	 * @return relative position (which are 2 float point numbers between 0 and
	 *         1, representing x and y coordinates, respectively) return value
	 *         is an array, array[0] indicates x coordinate, array[1] indicates
	 *         y coordinate. 
	 *         For example, array[0]=0; array[1]=0.5 means the
	 *         element is vertically in the middle of the playfield, and
	 *         horizontally on the left hand side of the playfield
	 * 
	 */
	double[] spawn();

	/**
	 * each spawn behavior will be associated with a check method, which means
	 * whether the spawning behavior should be carried out
	 * 
	 * @return true means the spawning behavior should be carried out, otherwise
	 *         don't carry out.
	 */
	boolean checkIfSpawn();

}