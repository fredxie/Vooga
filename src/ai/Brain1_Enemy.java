package ai;

import api.element.Enemy;
import api.game.Configuration;

public class Brain1_Enemy extends AI {

	public void refresh(long elapsedTime) {
		mySprite.setSpeed(0, 0.13);
		((Enemy) mySprite).setRefireRate(1200);
		AI.ENEMY_HP = 1.0;
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 1;
	}

}
