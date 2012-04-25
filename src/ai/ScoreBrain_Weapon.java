package ai;

import api.game.Configuration;

public class ScoreBrain_Weapon extends AI {
	double d;

	@Override
	public void refresh(long elaspedTime) {
		// TODO Auto-generated method stub
		double a = AI.ENEMY_WEAPON_DAMAGE;
		d = a + .5;
		AI.ENEMY_WEAPON_DAMAGE = d;

		double x = mySprite.getHorizontalSpeed();
		double y = mySprite.getVerticalSpeed();
		x = x * 1.3;
		mySprite.setHorizontalSpeed(x);
		y = y * 1.3;
		mySprite.setVerticalSpeed(y);
	}

}
