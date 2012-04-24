package demo.playerState;

/**
 * Yi Ding
 */

import api.element.Fighter;
import api.playerState.CollisionState;
import api.playerState.CollisionStatus;

import com.golden.gamedev.object.Timer;


public class PhysicCollisionStatus extends CollisionStatus {

	Timer validDuration = new Timer(10000);

	public PhysicCollisionStatus(CollisionState state) {

		super(state);
		collisionID = "Shield";
	}

	@Override
	public void update(long elapsedTime) {
		// TODO Auto-generated method stub

		if (validDuration.action(elapsedTime)) {
			state.changeState(new NormalCollisionStatus(state));
		}

	}

}
