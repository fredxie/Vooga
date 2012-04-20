package ai;

import game.Configuration;
import util.JsonUtil;
import configuration.GameParameters;

public class Brain4_Weapon extends AI{
	double background_speed = JsonUtil.parse("paraConfig.json").get(GameParameters.BACKGROUND_SPEED);

	@Override
	public void refresh(long elaspedTime) {
		// TODO Auto-generated method stub
		Configuration.ENEMY_WEAPON_DAMAGE = 2.0;
		mySprite.setSpeed(Math.random() * 0.25,Math.random()*0.2 + background_speed);
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 4;
	}
}