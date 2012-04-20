package ai;

import element.Missile; 
import javax.swing.Timer;

import game.Configuration;
import demo.DemoGameEngine;
import element.Bullet;
import element.Enemy;
import element.Missile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class BonusLimit implements EnemyTopDownBehavior
{
	Timer timer1;
	Timer timer2;
	Timer timer3;
	Timer timer4;
	Timer timer5;
	double d,h,x,y;
	
	public void enemy_Changes(final Enemy enemy)
	{
		enemy.setSpeed(0,.12);
		timer1 = new Timer(400, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e1) 
			{
				if(e1.getSource().equals(timer1))
				{
						enemy.setSpeed(-.25,.2);
						timer2.start();
				}
			}
		});
		timer2 = new Timer(400, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e2) 
			{
				if(e2.getSource().equals(timer2))
				{
					enemy.setSpeed(0, -.1);
//					enemy.setSpeed(.18, -.23);
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
					enemy.setSpeed(0, .25);
					timer4.start();
				}
			}
		});
		timer4 = new Timer(400, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e4) 
			{
				if(e4.getSource().equals(timer4))
				{
					enemy.setSpeed(0, .25);
//					enemy.setSpeed(0, -.1);
					timer5.start();
				}
			}
		});
		timer5 = new Timer(800, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e5) 
			{
				if(e5.getSource().equals(timer5))
				{
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
		x = enemy.getHorizontalSpeed();
		y = enemy.getVerticalSpeed();

		enemy.setRefireRate(500);
		Configuration.ENEMY_HP = h;
	}

	public void weapon_Changes(Missile missile) 
	{
		Configuration.ENEMY_WEAPON_DAMAGE = 1.0;
		double x2 = missile.getHorizontalSpeed();
		double y2 = missile.getVerticalSpeed();
		x2 = (x2 * 1.5) + x;
		missile.setHorizontalSpeed(x2);
		y2 = (y2 * 1.5) + y;
		missile.setVerticalSpeed(y2);
	}
	public int getState()
	{
		return 0; // setting as 0 since gamestate always starts at 1 and never reaches 0, these arent levels but ai changes based on changes in the game	
	}

//	public void weaponDamage(Missile missile)
//	{
//		missile.setDamage(1.0);
//	}
	
//	public void enemyHP(Enemy enemy)
//	{
//		double h = 1.0;
//		enemy.setHP(h);
//	}
}
