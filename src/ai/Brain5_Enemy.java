package ai;

import element.Enemy;
import game.Configuration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import util.JsonUtil;
import configuration.GameParameters;

public class Brain5_Enemy extends AI {
	Timer timer1;
	Timer timer2;
	Timer timer3;
	double rand,h,v; 
	double background_speed = JsonUtil.parse("paraConfig.json").get(GameParameters.BACKGROUND_SPEED);
	@Override
	public void refresh(long elaspedTime) {
		// TODO Auto-generated method stub
		rand = Math.random()*51;
		mySprite.setSpeed(0, .1);
		timer1 = new Timer(400, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e1) 
			{
				if(e1.getSource().equals(timer1))
				{
					if( rand < 10)
					{
						mySprite.setSpeed(Math.random() * 0.26,Math.random() * 0.26);
					}
					else if( rand >= 10 && rand <= 30)
					{
						mySprite.setSpeed(.2,.05);
					}
					else if( rand > 30 )
					{
						mySprite.setSpeed(-.05,.05);
						timer2.start();
					}
				}
			}
		});
		timer2 = new Timer(400, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e2) 
			{
				if(e2.getSource().equals(timer2))
				{
					mySprite.setSpeed(-.05, -.07);
					timer3.start();
				}
			}
		});
		timer3 = new Timer(400, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e3) 
			{
				if(e3.getSource().equals(timer3))
				{
					mySprite.setSpeed(0, .12);
				}
			}
		});
		timer1.start();
		timer1.setRepeats(true);
	
		((Enemy) mySprite).setRefireRate(600);
		AI.ENEMY_HP = 3.5;
	}
	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 5;
	}

}
