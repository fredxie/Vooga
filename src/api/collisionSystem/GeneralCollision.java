package api.collisionSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import api.element.RegularFighter;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.CollisionGroup;

/**
 * This class extends CollisionGroup in GTGE. It detects collision between its two registered Sprites, 
 * and reacts a list of CollisionAction as collision effect. It can handle collision with state.
 * 
 * @param pixelPerfectCollision
 *               This collision is pixel precision.
 * @param generalList
 *               This list stores  a list of CollisionAction to react the collision effect, which is regardless of state.
 * @param stateMap
 *               This map stores each state maps to a list of CollisionAction.
 * 
 * @author Yi Ding
 *
 */
public class GeneralCollision extends CollisionGroup {

	{
		pixelPerfectCollision = true;
	}

	private List<CollisionAction> generalList;

	private HashMap<String, List<CollisionAction>> stateMap;

	public GeneralCollision(List<CollisionAction> coolList) {
		super();
		generalList = coolList;

	}

	public GeneralCollision() {
		super();
		generalList = new ArrayList<CollisionAction>();
		stateMap = new HashMap<String, List<CollisionAction>>();
	}
	
	/**
	 * Add a general CollisionAction to the generalList.
	 * 
	 * @param collide
	 */

	public void addGeneralAction(CollisionAction collide) {
		generalList.add(collide);
	}
	
	/**
	 * Add a state CollisionAction to the currentState entry of stateMap
	 * 
	 * @param currentState
	 * @param collide
	 */

	public void addStateAction(String currentState, CollisionAction collide) {
		if (!stateMap.containsKey(currentState)) {
			ArrayList<CollisionAction> stateAction = new ArrayList<CollisionAction>();
			stateMap.put(currentState, stateAction);
		}
		stateMap.get(currentState).add(collide);

	}
	
	/**
	 * This method is a reaction to the detection of collision.
	 * It will execute the CollisionActions' effect corresponding to the collision.
	 * 
	 */

	@Override

	public void collided(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
		for (CollisionAction collision : generalList)
			collision.oncollide(s1, s2);

		if (s1 instanceof RegularFighter) {
			String currentstate = ((RegularFighter) s1).getStateManager()
					.getCollisionID();

			if (stateMap.containsKey(currentstate))
				for (CollisionAction collision : stateMap.get(currentstate))
					collision.oncollide(s1, s2);
		}

	}

}