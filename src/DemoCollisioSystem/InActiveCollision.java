package DemoCollisioSystem;

import collisionSystem.CollisionAction;

import com.golden.gamedev.object.Sprite;

public class InActiveCollision extends CollisionAction {
	
	public void oncollide(Sprite s1, Sprite s2) {
		
		s2.setActive(false);
		
	}


}
