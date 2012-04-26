package demo.ai;

import api.ai.AI;
import api.util.JsonUtil;

public class Brain4_Weapon extends AI {
	double background_speed = JsonUtil.parse("json/paraConfig.json").get(
			"BACKGROUND_SPEED");

	@Override
	public void refresh(long elaspedTime) {
		// TODO Auto-generated method stub
		AI.ENEMY_WEAPON_DAMAGE = 2.0;
		mySprite.setSpeed(Math.random() * 0.25, Math.random() * 0.15
				+ background_speed);
	}

}
