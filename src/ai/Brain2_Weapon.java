package ai;

import game.Configuration;

public class Brain2_Weapon extends AI {

	@Override
	public void refresh(long elaspedTime) {
		// TODO Auto-generated method stub
		if (Math.random() * 10 > 5) {
			mySprite.setHorizontalSpeed(.1);
		} else {
			mySprite.setHorizontalSpeed(-.1);
		}
		mySprite.setVerticalSpeed(.3);

		AI.ENEMY_WEAPON_DAMAGE = 1.0;
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 2;
	}

}
