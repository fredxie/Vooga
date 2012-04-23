package playerState;

/**
 * Yi Ding
 */
import com.golden.gamedev.object.Timer;

import element.Fighter;

public class PhysicCollisionState extends CollisionStatus{
    
	Timer validDuration = new Timer(10000);
	public PhysicCollisionState(CollisionState state) {

		super(state);
		collisionID = "Shield";
	}
	
	
	
	
	
	
	@Override
	public void update(long elapsedTime) {
		// TODO Auto-generated method stub
		
		if(validDuration.action(elapsedTime))
		{
			state.changeState(new NormalCollisionState(state));
		}
		
		
	}

}
