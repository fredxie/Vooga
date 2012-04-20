package collisionSystem;

import element.Fighter;
import game.Configuration;

import com.golden.gamedev.object.Sprite;

public class FighterEnemyOrBlockCollision extends CoolCollision {

	@Override
	void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
		s2.setActive(false);

		if(((Fighter) s1).getLifeNum()==1)
		{
			((Fighter) s1).setLifeNum(0);
			s1.setActive(false);

		}

		else {

			((Fighter) s1).setHP(Configuration.FIGHTER_HP);

			((Fighter) s1).setLifeNum(((Fighter) s1).getLifeNum() - 1);
		}

		
	}

}
