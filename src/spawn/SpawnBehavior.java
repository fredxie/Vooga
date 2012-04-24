/**
 * @author Gang Song
 */

package spawn;

public interface SpawnBehavior {

	double[] spawn();

	/**
	 * each spawn behavior will be associated with a check method, which means
	 * whether the spawning behavior should be carried out
	 * 
	 * @return true means the spawning behavior should be carried out, otherwise
	 *         don't carry out.
	 */
	boolean check();

}