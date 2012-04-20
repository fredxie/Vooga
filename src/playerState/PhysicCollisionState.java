package playerState;

import com.golden.gamedev.object.Timer;

import element.Fighter;

public class PhysicCollisionState extends CollisionState{
    
	Timer validDuration = new Timer(5000);
	public PhysicCollisionState(Fighter fighter) {
		super(fighter);
		collisionID = "Shield";
	}

	@Override
	public void update(long elapsedTime) {
		if(validDuration.action(elapsedTime))
		{
			changeState(new NormalCollisionState(fighter));
		}
		
	}
}
