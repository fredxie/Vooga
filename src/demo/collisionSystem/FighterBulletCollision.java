package demo.collisionSystem;



import api.collisionSystem.CollisionAction;
import api.element.Fighter;
import api.element.Weapon;
import api.game.Configuration;
import api.util.JsonUtil;

import com.golden.gamedev.object.Sprite;

public class FighterBulletCollision extends CollisionAction {

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

				((Fighter) s1).setHP(JsonUtil.parse("paraConfig.json").get(
						"FIGHTER_HP"));

				((Fighter) s1).setLifeNum(((Fighter) s1).getLifeNum() - 1);
			}

		}

	}

}
