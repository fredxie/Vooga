package ai;

import game.Configuration;
import util.JsonUtil;
import configuration.api.GameParameters;

public class Brain5_Weapon extends AI{
	double h,v;
	double background_speed = JsonUtil.parse("paraConfig.json").get(GameParameters.BACKGROUND_SPEED);
	@Override
	public void refresh(long elaspedTime) {
		// TODO Auto-generated method stub
		AI.ENEMY_WEAPON_DAMAGE = 2.5;
		h = Math.random() * 0.25;
		v = Math.random() * 0.35 + background_speed;
		if(Math.random()*51 < 25)
		{
			mySprite.setSpeed(h,v);
		}
		else{ 
			mySprite.setSpeed(-h,v);
		}
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 5;
	}

}
