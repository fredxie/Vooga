package demo.collisionSystem;



import api.collisionSystem.CollisionAction;
import api.element.Fighter;
import api.element.Weapon;
import api.util.JsonUtil;

import com.golden.gamedev.object.Sprite;


/**
 * This class extends CollisionAction to define a collision effect between Fighter and Bullet.
 * @author Yi Ding
 *
 */
public class FighterBulletCollision extends CollisionAction {

	@SuppressWarnings("static-access")
	@Override
	public void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub

		s2.setActive(false);
		((Fighter) s1)
				.setHP(((Fighter) s1).getHP() - ((Weapon) s2).getDamage());
		if (((Fighter) s1).getHP() <= 0) {
			if (((Fighter) s1).getLifeNum() == 1)
				s1.setActive(false);
			else {

				((Fighter) s1).setHP(JsonUtil.parse("json/paraConfig.json").get(
						"FIGHTER_HP"));

				((Fighter) s1).setLifeNum(((Fighter) s1).getLifeNum() - 1);
			}

		}

	}

}
