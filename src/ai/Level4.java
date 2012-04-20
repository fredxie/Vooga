package ai;
import element.*; 
import game.*;
import collision.*;
import demo.*;
import game.Configuration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.Timer;

import util.JsonUtil;
import configuration.GameParameters;

import element.Enemy;
import element.Missile;
import element.TopDownBackground;
public class Level4 implements EnemyTopDownBehavior
{
	double d,hp,h,v;
	double x = Math.random() * 50;
	Timer timer;
	double background_speed = JsonUtil.parse("paraConfig.json").get(GameParameters.BACKGROUND_SPEED);

	public void enemy_Changes(final Enemy enemy)
	{
		enemy.setSpeed(.2, .12);
		timer = new Timer(400, new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource().equals(timer))
				{
					if( x < 10 )
					{
						enemy.setSpeed(Math.random() * 0.26,Math.random()*0.26  + background_speed );
					}
					else if( x >= 10 )
					{
						enemy.setSpeed(.2,.2);
					}
				}
			}
		});
		timer.start();
		timer.setRepeats(true);
		enemy.setSpeed(h,v);

		enemy.setRefireRate(600);
		Configuration.ENEMY_HP = 3.0;
	}
	public void weapon_Changes(Missile missile)
	{	
		Configuration.ENEMY_WEAPON_DAMAGE = 2.0;
		missile.setSpeed(Math.random() * 0.25,Math.random()*0.2 + background_speed);
	}
	public int getState()
	{
		return 4;
	}
//	public void enemyHP(Enemy enemy)
//	{
//		double h = 3.0;
//		enemy.setHP(h);
//	}
//	public void weaponDamage(Missile missile)
//	{
//		missile.setDamage(2.0);
//	}
}
