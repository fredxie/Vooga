package demo.ai;

import api.ai.AI;
import api.util.JsonUtil;

public class Brain5_Weapon extends AI {
	double h, v;
	double background_speed = JsonUtil.parse("json/paraConfig.json").get(
			"BACKGROUND_SPEED");

	@Override
	public void refresh(long elaspedTime) {
		// TODO Auto-generated method stub
		AI.ENEMY_WEAPON_DAMAGE = 2.5;
		h = Math.random() * 0.25;
		v = Math.random() * 0.2 + background_speed;
		if (Math.random() * 51 < 25) {
			mySprite.setSpeed(h, v);
		} else {
			mySprite.setSpeed(-h, v);
		}
	}
}
