package ai;

import game.Configuration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Brain3_Weapon extends AI{

	Timer timer;
	
	@Override
	public void refresh(long elaspedTime) {
		// TODO Auto-generated method stub
		AI.ENEMY_WEAPON_DAMAGE = 1.5;
		
		/*
		 * bullets zig zag every half second
		 */
		final double s = .25;
		mySprite.setVerticalSpeed(.35);
		if(Math.random()*10 > 5)
		{
			mySprite.setHorizontalSpeed(s);
		}
		else {
			mySprite.setHorizontalSpeed(-s);
		}
		
		timer = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(timer)){
					mySprite.setHorizontalSpeed(-s);
				}
			}
		});
		timer.setRepeats(true);
		timer.start();
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 3;
	}

}
