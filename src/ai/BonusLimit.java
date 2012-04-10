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

public class BonusLimit implements TopDownBehavior
{
	Timer timer1;
	Timer timer2;
	Timer timer3;
	double d,h;
	
	public void movement(final Enemy enemy)
	{
		enemy.setSpeed(0,.12);
		timer1 = new Timer(400, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e1) 
			{
				if(e1.getSource().equals(timer1))
				{
						enemy.setSpeed(-.15,.1);
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
					enemy.setSpeed(.1, -.2);
					timer3.start();
				}
			}
		});
		timer3 = new Timer(800, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e3) 
			{
				if(e3.getSource().equals(timer3))
				{
					enemy.setSpeed(0, .2);
					timer1.restart();
				}
			}
		});
		timer1.start();
		timer1.setRepeats(true);
		timer2.setRepeats(true);
		timer3.setRepeats(true);
		
	}
	public void fireRate(Enemy enemy)
	{
		enemy.setRefireRate(500);
	}
	public double enemyDamage()
	{
		Configuration.ENEMY_WEAPON_DAMAGE = 1.0;
		return d = 1.0;	
	}
	public void weaponDamage(Missile missile)
	{
		missile.setDamage(1.0);
	}
	public void weaponSpeed(Missile missile)
	{
		double x = missile.getHorizontalSpeed();
		double y = missile.getVerticalSpeed();
		x = x * 1.5;
		missile.setHorizontalSpeed(x);
		y = y * 1.5;
		missile.setVerticalSpeed(y);
	}
	public double enemyHP()
	{
		return h = 1.0;
	}
//	public void enemyHP(Enemy enemy)
//	{
//		double h = 1.0;
//		enemy.setHP(h);
//	}
	public double getState()
	{
		return 0; // setting as 0 since gamestate always starts at 1 and never reaches 0, these arent levels but ai changes based on changes in the game	
	}
}
