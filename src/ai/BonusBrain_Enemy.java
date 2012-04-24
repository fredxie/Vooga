package ai;

import element.Enemy;
import game.Configuration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class BonusBrain_Enemy extends AI {
	Timer timer1;
	Timer timer2;
	Timer timer3;
	Timer timer4;
	Timer timer5;
	double d, h, x, y;

	@Override
	public void refresh(long elaspedTime) {
		// TODO Auto-generated method stub
		mySprite.setSpeed(0, .12);
		timer1 = new Timer(400, new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				if (e1.getSource().equals(timer1)) {
					mySprite.setSpeed(-.25, .2);
					timer2.start();
				}
			}
		});
		timer2 = new Timer(400, new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				if (e2.getSource().equals(timer2)) {
					mySprite.setSpeed(0, -.1);
					// enemy.setSpeed(.18, -.23);
					timer3.start();
				}
			}
		});
		timer3 = new Timer(400, new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				if (e3.getSource().equals(timer3)) {
					mySprite.setSpeed(0, .25);
					timer4.start();
				}
			}
		});
		timer4 = new Timer(400, new ActionListener() {
			public void actionPerformed(ActionEvent e4) {
				if (e4.getSource().equals(timer4)) {
					mySprite.setSpeed(0, .25);
					// enemy.setSpeed(0, -.1);
					timer5.start();
				}
			}
		});
		timer5 = new Timer(800, new ActionListener() {
			public void actionPerformed(ActionEvent e5) {
				if (e5.getSource().equals(timer5)) {
					timer1.restart();
				}
			}
		});
		timer1.start();
		timer1.setRepeats(true);
		timer2.setRepeats(true);
		timer3.setRepeats(true);
		timer4.setRepeats(true);
		timer5.setRepeats(true);
		x = mySprite.getHorizontalSpeed();
		y = mySprite.getVerticalSpeed();

		((Enemy) mySprite).setRefireRate(500);
		AI.ENEMY_HP = h;
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}

}
