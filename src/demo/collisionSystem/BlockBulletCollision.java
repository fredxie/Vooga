package demo.collisionSystem;


import api.collisionSystem.CollisionAction;
import api.element.Block;

import com.golden.gamedev.object.Sprite;

/**
 * This class extends CollisionAction to define a collision effect between Block and Bullet.
 * 
 * @author Yi Ding
 *
 */

public class BlockBulletCollision extends CollisionAction {

	@Override
	public void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
		s2.setActive(false);
		if (((Block) s1).isDestroyable()) {
			((Block) s1).decreaseHardDegree();
			if (((Block) s1).getHardDegree() == 0)
				s1.setActive(false);
		}
	}

}
