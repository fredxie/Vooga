package api.playerState;

import api.element.Fighter;

/**
 * This class performs as the state class of collision, called when collision
 * occurs, the class can decide the effect of collision
 * 
 * @author ShiyuanWang & Yi Ding
 */
public class CollisionState extends PlayerState {
	protected String collisionID;
	CollisionStatus collisionStatus;

	public CollisionState(Fighter fighter) {
		super(fighter);

	}

	public CollisionState(Fighter fighter, CollisionStatus status) {
		super(fighter);
		collisionStatus = status;
		collisionID = collisionStatus.collisionID;

	}

	/**
	 * Change the collision State according to the passed collisionStatus
	 */

	public void changeState(Object collisionState) {
		collisionStatus = (CollisionStatus) collisionState;
		collisionID = collisionStatus.collisionID;
	}

	/**
	 * Return the ID of the Collision State to give the hint of the effect of
	 * collision
	 */
	public String getID() {
		return collisionID;
	}

	/**
	 * Update the collision State according to time
	 */
	@Override
	public void update(long elapsedTime) {
		collisionStatus.update(elapsedTime);
	}

}