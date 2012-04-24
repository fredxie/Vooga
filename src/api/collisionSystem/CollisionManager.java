package api.collisionSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import api.element.ElementGroup;
import api.element.TopDownPlayField;
import api.playerState.PlayerState;



public class CollisionManager {

	private TopDownPlayField playfield;
	// private HashMap<String, List<CoolCollision>> actionMap;

	private HashMap<String, GeneralCollision> collisionMap;

	public CollisionManager(TopDownPlayField playfield) {
		this.playfield = playfield;
		// actionMap = new HashMap<String,List<CoolCollision>>();
		collisionMap = new HashMap<String, GeneralCollision>();
	}


	public void registerCollision(String s1, String s2,
			CollisionAction... collide) {
		String collisionType = registerCollision(s1, s2);

		for (CollisionAction cool : collide)
			collisionMap.get(collisionType).addGeneralAction(cool);
	}

	public void registerCollision(String s1, String currentState, String s2,
			CollisionAction... collide) {
		String collisionType = registerCollision(s1, s2);
		for (CollisionAction cool : collide)
			collisionMap.get(collisionType).addStateAction(currentState, cool);
	}

	public String registerCollision(String s1, String s2) {
		if (playfield.getGroup(s1) == null)
			playfield.addGroup(new ElementGroup(s1));
		if (playfield.getGroup(s2) == null)
			playfield.addGroup(new ElementGroup(s2));
		String collisionType = s1 + s2;

		if (!collisionMap.containsKey(collisionType)) {
			GeneralCollision collision = new GeneralCollision();
			collisionMap.put(collisionType, collision);
			playfield.addCollisionGroup(playfield.getGroup(s1),
					playfield.getGroup(s2), collision);
		}

		return collisionType;
		// actionMap.get(collisionType).add(collide);
	}

}
