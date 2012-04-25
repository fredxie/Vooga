package api.playerState;

/**
 * This class extends CollisionStatus to perform as a concrete normal collisionStatus, called when collision
 * occurs, the class can decide the effect of collision
 * 
 * @author Yi Ding
 * 
 */
 


public class NormalCollisionStatus extends CollisionStatus {

	public NormalCollisionStatus(CollisionState state) {
		super(state);
		collisionID = "Normal";
	}

	@Override
	public void update(long elapsedTime) {
		// TODO Auto-generated method stub

	}

}
