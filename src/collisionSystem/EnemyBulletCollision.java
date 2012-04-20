package collisionSystem;

import com.golden.gamedev.object.Sprite;

import element.Bullet;
import element.Enemy;

public class EnemyBulletCollision extends CoolCollision{

	public static int destroyed=0;

	@Override
	void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
		s2.setActive(false);	
		((Enemy) s1).setHP(((Enemy) s1).getHP()-((Bullet) s2).getDamage());
		if (((Enemy) s1).getHP() <= 0 )
		{
            s1.setActive(false);
            destroyed++;
	
		}	
	}

	
	
}
 