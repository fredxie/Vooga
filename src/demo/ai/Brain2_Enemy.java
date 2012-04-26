package demo.ai;

import api.ai.AI;
import api.element.Enemy;

public class Brain2_Enemy extends AI {

	public void refresh(long elapsedTime) {
		mySprite.setSpeed(.1, .13);
		((Enemy) mySprite).setRefireRate(900);
		AI.ENEMY_HP = 2.0;
	}

}
