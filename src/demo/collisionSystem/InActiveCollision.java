package demo.collisionSystem;


import api.collisionSystem.CollisionAction;

import com.golden.gamedev.object.Sprite;

/**
 * This class extends CollisionAction to define a collision effect.
 * @author Yi Ding
 *
 */
public class InActiveCollision extends CollisionAction {

	public void oncollide(Sprite s1, Sprite s2) {

		s2.setActive(false);

	}

}
