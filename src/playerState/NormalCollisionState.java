package playerState;

import com.golden.gamedev.object.Sprite;

import element.Fighter;

public class NormalCollisionState extends CollisionState{

	public NormalCollisionState(Fighter fighter) {
		super(fighter);
		collisionID = "Normal";
	}

	@Override
	public void update(long elapsedTime) {
		// TODO Auto-generated method stub
		
	}

}

