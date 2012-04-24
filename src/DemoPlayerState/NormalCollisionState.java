package DemoPlayerState;

/**
 * Yi Ding
 */
import playerState.CollisionState;
import playerState.CollisionStatus;

import com.golden.gamedev.object.Sprite;

import element.Fighter;

public class NormalCollisionState extends CollisionStatus{

	public NormalCollisionState(CollisionState state) {
		super(state);
		collisionID = "Normal";
	}

	@Override
	public void update(long elapsedTime) {
		// TODO Auto-generated method stub
		
	}



}

