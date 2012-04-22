package collisionSystem;

import util.JsonUtil;
import element.Fighter;
import element.Weapon;
import game.Configuration;

import com.golden.gamedev.object.Sprite;

import configuration.GameParameters;

public class FighterBulletCollision extends CoolCollision{

	@Override
	void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
		
		s2.setActive(false);
		((Fighter) s1).setHP(((Fighter) s1).getHP() - ((Weapon) s2).getDamage());
		if (((Fighter) s1).getHP() <= 0) {
			if (((Fighter) s1).getLifeNum() == 1)
				s1.setActive(false);
			else {

				((Fighter) s1).setHP(JsonUtil.parse("paraConfig.json").get(
						GameParameters.FIGHTER_HP));

				((Fighter) s1).setLifeNum(((Fighter) s1).getLifeNum() - 1);
			}

		}
		
	}

}
