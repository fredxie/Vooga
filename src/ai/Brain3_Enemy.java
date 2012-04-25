package ai;

import api.element.Enemy;
import api.game.Configuration;

public class Brain3_Enemy extends AI {

	@Override
	public void refresh(long elaspedTime) {
		// TODO Auto-generated method stub
		mySprite.setSpeed(0.15, 0.15);
		((Enemy) mySprite).setRefireRate(700);
		AI.ENEMY_HP = 2.5;
	}

}
