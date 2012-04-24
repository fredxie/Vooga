package api.playerState;

/**
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
