package api.playerState;

/**
 * This class performs as the status class to define each collisionState, called when collision
 * occurs, the class can decide the effect of collision
 * 
 * @author Yi Ding
 * 
 */

public abstract class CollisionStatus {

	protected String collisionID;
	protected CollisionState state;

	public CollisionStatus(CollisionState state) {
		this.state = state;
	}

	public abstract void update(long elapsedTime);

}
