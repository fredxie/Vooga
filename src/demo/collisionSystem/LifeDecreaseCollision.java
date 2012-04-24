package demo.collisionSystem;



import api.collisionSystem.CollisionAction;
import api.element.Block;
import api.element.Enemy;
import api.element.Fighter;
import api.element.Weapon;
import api.game.Configuration;
import api.util.JsonUtil;

import com.golden.gamedev.object.Sprite;


public class LifeDecreaseCollision extends CollisionAction {

	public static int destroyed = 0;

	@Override
	public void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub

		if ((s1 instanceof Fighter)
				&& ((s2 instanceof Enemy) || (s2 instanceof Block))) {
			s2.setActive(false);

			if (((Fighter) s1).getLifeNum() == 1) {
				((Fighter) s1).setLifeNum(0);
				s1.setActive(false);

			}

			else {

				((Fighter) s1).setHP(JsonUtil.parse("paraConfig.json").get(
						"FIGHTER_HP"));

				((Fighter) s1).setLifeNum(((Fighter) s1).getLifeNum() - 1);
			}
		}

		if ((s1 instanceof Fighter) && (s2 instanceof Weapon)) {
			s2.setActive(false);
			((Fighter) s1).setHP(((Fighter) s1).getHP()
					- ((Weapon) s2).getDamage());
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

		if ((s1 instanceof Enemy) && (s2 instanceof Weapon))

		{
			s2.setActive(false);
			((Enemy) s1)
					.setHP(((Enemy) s1).getHP() - ((Weapon) s2).getDamage());
			if (((Enemy) s1).getHP() <= 0) {
				s1.setActive(false);
				destroyed++;

			}
		}

		if ((s1 instanceof Block) && (s2 instanceof Weapon)) {
			s2.setActive(false);
			if (((Block) s1).isDestroyable()) {
				((Block) s1).decreaseHardDegree();
				if (((Block) s1).getHardDegree() == 0)
					s1.setActive(false);
			}
		}

	}

}
