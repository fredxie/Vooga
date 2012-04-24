package playerState;

import com.golden.gamedev.object.Timer;

import element.Fighter;

public class CollisionState extends PlayerState {
	protected String collisionID;
	CollisionStatus collisionStatus;

	// Timer shieldLength = new Timer(5000);

	// public CollisionState(Fighter fighter, CollisionState collisionState) {
	// super(fighter);
	// this.collisionState=collisionState;
	//
	// }

	public CollisionState(Fighter fighter) {
		super(fighter);

	}

	public CollisionState(Fighter fighter, CollisionStatus status) {
		super(fighter);
		collisionStatus = status;
		collisionID = collisionStatus.collisionID;

	}

	public void changeState(Object collisionState) {
		collisionStatus = (CollisionStatus) collisionState;
		collisionID = collisionStatus.collisionID;
	}

	public String getID() {
		return collisionID;
	}

	@Override
	public void update(long elapsedTime) {
		// TODO Auto-generated method stub

		collisionStatus.update(elapsedTime);
	}

}
