package DemoCollisioSystem;

import collisionSystem.CollisionAction;

import com.golden.gamedev.object.Sprite;

import element.Block;

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
