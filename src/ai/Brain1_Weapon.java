package ai;

import game.Configuration;

public class Brain1_Weapon extends AI{

	@Override
	public void refresh(long elaspedTime) {
		// TODO Auto-generated method stub
		AI.ENEMY_WEAPON_DAMAGE = .25;
		mySprite.setHorizontalSpeed(0);
		mySprite.setVerticalSpeed(.25);
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 1;
	}
	

}
