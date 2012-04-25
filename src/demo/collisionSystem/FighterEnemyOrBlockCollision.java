package demo.collisionSystem;



import api.collisionSystem.CollisionAction;
import api.element.Fighter;
import api.game.Configuration;
import api.util.JsonUtil;

import com.golden.gamedev.object.Sprite;

/**
 * This class extends CollisionAction to define a collision effect between Fighter and Enemy/Block.
 * @author Yi Ding
 *
 */
public class FighterEnemyOrBlockCollision extends CollisionAction {

	@Override
	public void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
		s2.setActive(false);

		if (((Fighter) s1).getLifeNum() == 1) {
			((Fighter) s1).setLifeNum(0);
			s1.setActive(false);

		}

		else {

			((Fighter) s1).setHP(JsonUtil.parse("json/paraConfig.json").get(
					"FIGHTER_HP"));

			((Fighter) s1).setLifeNum(((Fighter) s1).getLifeNum() - 1);
		}

	}

}
