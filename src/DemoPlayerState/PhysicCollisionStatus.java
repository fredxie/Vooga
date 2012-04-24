package DemoPlayerState;

/**
 * Yi Ding
 */
import playerState.CollisionState;
import playerState.CollisionStatus;

import com.golden.gamedev.object.Timer;

import element.Fighter;

public class PhysicCollisionStatus extends CollisionStatus{
    
	Timer validDuration = new Timer(10000);
	public PhysicCollisionStatus(CollisionState state) {

		super(state);
		collisionID = "Shield";
	}
	
	
	
	
	
	
	@Override
	public void update(long elapsedTime) {
		// TODO Auto-generated method stub
		
		if(validDuration.action(elapsedTime))
		{
			state.changeState(new NormalCollisionStatus(state));
		}
		
		
	}

}
