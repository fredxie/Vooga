package ai;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import api.element.Enemy;
import api.util.JsonUtil;


public class Brain4_Enemy extends AI {
	double x = Math.random() * 50;
	Timer timer;
	double background_speed = JsonUtil.parse("json/paraConfig.json").get(
			"BACKGROUND_SPEED");

	@Override
	public void refresh(long elaspedTime) {
		// TODO Auto-generated method stub
		mySprite.setSpeed(.2, .12);
		timer = new Timer(400, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(timer)) {
					if (x < 10) {
						mySprite.setSpeed(Math.random() * 0.26, Math.random()
								* 0.26 + background_speed);
					} else if (x >= 10) {
						mySprite.setSpeed(.2, .2);
					}
				}
			}
		});
		timer.start();
		timer.setRepeats(true);

		((Enemy) mySprite).setRefireRate(600);
		AI.ENEMY_HP = 3.0;
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 4;
	}

}
