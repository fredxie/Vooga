package ai;

import element.Enemy;
import game.Configuration;

public class Brain3_Enemy extends AI{

	@Override
	public void refresh(long elaspedTime) {
		// TODO Auto-generated method stub
		mySprite.setSpeed(0.15,0.15);
		((Enemy) mySprite).setRefireRate(700);
		Configuration.ENEMY_HP = 2.5;
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 3;
	}

}
