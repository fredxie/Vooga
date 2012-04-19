package collisionSystem;

import com.golden.gamedev.object.Sprite;

public class InActiveCollision extends CoolCollision {
	
	void oncollide(Sprite s1, Sprite s2) {
		
		s2.setActive(false);
		
	}


}
