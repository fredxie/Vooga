package api.collisionSystem;

import java.util.HashMap;

import api.element.ElementGroup;
import api.game.TopDownPlayField;

/**
 * This class is a collision manager to help developer manage different collisions between SpriteGroups in the game.
 * 
 * @param playfield
 *             playfield this manager is current in
 * @param collisionMap
 *             a Map stores a pair of registered SpriteGroups that maps to a GeneralCollision. 
 *             The GeneralCollision deals with collision between this pair of SpriteGroups.
 * @param 
 * 
 * @author Yi Ding
 *
 */

public class CollisionManager {

	private TopDownPlayField playfield;

	private HashMap<String, GeneralCollision> collisionMap;

	public CollisionManager(TopDownPlayField playfield) {
		this.playfield = playfield;
		// actionMap = new HashMap<String,List<CoolCollision>>();
		collisionMap = new HashMap<String, GeneralCollision>();
	}

/**
 * register a GeneralCollision between two types of Sprites, s1 and s2.
 * Add a list of CollisionAction to this collision.
 * 
 * @param s1
 * @param s2
 * @param collide
 */
	
	public void registerCollision(String s1, String s2,
			CollisionAction... collide) {
		String collisionType = registerCollision(s1, s2);

		for (CollisionAction cool : collide)
			collisionMap.get(collisionType).addGeneralAction(cool);
	}

/**
 * register a GeneralCollision between two types of Sprites, s1 and s2.
 * Add a list of CollisionAction to this collision when s1 is in state currentState.
 * 
 * @param s1
 * @param currentState
 * @param s2
 * @param collide
 */
	public void registerCollision(String s1, String currentState, String s2,
			CollisionAction... collide) {
		String collisionType = registerCollision(s1, s2);
		for (CollisionAction cool : collide)
			collisionMap.get(collisionType).addStateAction(currentState, cool);
	}

/**
 * register a GeneralCollision between two types of Sprites, s1 and s2
 * 
 * @param s1
 * @param s2
 * @return String
 *           return the sum of sprite String ID as a unique collision ID.
 */
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
