package api.collisionSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import api.element.RegularFighter;
import api.playerState.PlayerState;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.CollisionGroup;


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

	public void addGeneralAction(CollisionAction collide) {
		generalList.add(collide);
	}

	public void addStateAction(String currentState, CollisionAction collide) {
		if (!stateMap.containsKey(currentState)) {
			ArrayList<CollisionAction> stateAction = new ArrayList<CollisionAction>();
			stateMap.put(currentState, stateAction);
		}
		stateMap.get(currentState).add(collide);

	}

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
