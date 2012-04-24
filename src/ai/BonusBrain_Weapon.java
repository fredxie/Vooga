package ai;

import game.Configuration;

public class BonusBrain_Weapon extends AI{
	
	@Override
	public void refresh(long elaspedTime) {
		// TODO Auto-generated method stub
		AI.ENEMY_WEAPON_DAMAGE = 1.0;
		double x2 = mySprite.getHorizontalSpeed();
		double y2 = mySprite.getVerticalSpeed();
		x2 = (x2 * 1.5);
		y2 = (y2 * 1.5);
		mySprite.setSpeed(x2,y2);
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}

}
