package demo.playerState;

/**
 * Yi Ding
 */

import api.element.Fighter;
import api.playerState.CollisionState;
import api.playerState.CollisionStatus;

import com.golden.gamedev.object.Sprite;


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
