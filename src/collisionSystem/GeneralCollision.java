package collisionSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import playerState.PlayerState;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.CollisionGroup;

import element.RegularFighter;

public class GeneralCollision extends CollisionGroup {

	{
		pixelPerfectCollision = true;
	}

	private List<CoolCollision> generalList;

	private HashMap<String, List<CoolCollision>> stateMap;

	public GeneralCollision(List<CoolCollision> coolList) {
		super();
		generalList = coolList;

	}

	public GeneralCollision() {
		super();
		generalList = new ArrayList<CoolCollision>();
		stateMap = new HashMap<String, List<CoolCollision>>();
	}

	public void addGeneralAction(CoolCollision collide) {
		generalList.add(collide);
	}

	public void addStateAction(String currentState, CoolCollision collide) {
		if (!stateMap.containsKey(currentState)) {
			ArrayList<CoolCollision> stateAction = new ArrayList<CoolCollision>();
			stateMap.put(currentState, stateAction);
		}
		stateMap.get(currentState).add(collide);

	}

	@Override
	public void collided(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
		for (CoolCollision collision : generalList)
			collision.oncollide(s1, s2);

		if(s1 instanceof RegularFighter)
		{
		String currentstate = ((RegularFighter) s1).getCollisionState().getID();

		if (stateMap.containsKey(currentstate))
			for (CoolCollision collision : stateMap.get(currentstate))
				collision.oncollide(s1, s2);
		}

	}

}
