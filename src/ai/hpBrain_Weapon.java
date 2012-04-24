package ai;

import api.game.Configuration;

public class hpBrain_Weapon extends AI {
	double d;

	@Override
	public void refresh(long elaspedTime) {
		// TODO Auto-generated method stub
		double a = AI.ENEMY_WEAPON_DAMAGE;
		if (a > .5 && a < 2.5) {
			d = a - .5;
		} else if (a >= 2.5) {
			d = a - 1.0;
		} else if (a <= .5) {
			d = a;
		}
		AI.ENEMY_WEAPON_DAMAGE = d;

		double x = mySprite.getHorizontalSpeed();
		double y = mySprite.getVerticalSpeed();
		if (x > 0) {
			x = x * .5;
			mySprite.setHorizontalSpeed(x);
		}
		y = y * 0.75;
		mySprite.setVerticalSpeed(y);
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}
}
