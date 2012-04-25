package demo.collisionSystem;


import api.collisionSystem.CollisionAction;
import api.element.Enemy;
import api.element.Weapon;

import com.golden.gamedev.object.Sprite;

/**
 * This class extends CollisionAction to define a collision effect between Enemy and Bullet.

 * @author Yi Ding
 *
 */

public class EnemyBulletCollision extends CollisionAction {

	public static int destroyed = 0;

	@Override
	public void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
		s2.setActive(false);
		((Enemy) s1).setHP(((Enemy) s1).getHP() - ((Weapon) s2).getDamage());

		if (((Enemy) s1).getHP() <= 0) {
			s1.setActive(false);
			destroyed++;

		}
	}

}
