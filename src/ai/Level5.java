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

import element.Missile;
public class Level5 implements TopDownBehavior
{
	Timer timer1;
	Timer timer2;
	Timer timer3;
	double d,hp,rand,h,v,x,y; 

	public void movement(final Enemy enemy)
	{
		rand = Math.random()*51;
		enemy.setSpeed(0, .1);
		timer1 = new Timer(400, new ActionListener() 
		{
			public void actionPerformed(ActionEvent e1) 
			{
				if(e1.getSource().equals(timer1))
				{
					if( rand < 10)
					{
						enemy.setSpeed(Math.random() * 0.26,Math.random() * 0.26);
					}
					else if( rand >= 10 && rand <= 30)
					{
						enemy.setSpeed(.2,.05);
					}
					else if( rand > 30 )
					{
						enemy.setSpeed(-.05,.05);
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
					enemy.setSpeed(-.05, -.07);
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
					enemy.setSpeed(0, .12);
				}
			}
		});
		timer1.start();
		timer1.setRepeats(true);
	}

	public void fireRate(Enemy enemy)
	{
		enemy.setRefireRate(600);
	}
	public double enemyDamage()
	{
		Configuration.ENEMY_WEAPON_DAMAGE = 2.5;
		return d = 2.5;
	}

//	public void weaponDamage(Bullet bullet)
//	{
//		bullet.setDamage(3);
//	}
	public void weaponSpeed(Missile missile)
	{	
		/*
		 * in this level, the hypothetical final level on hard, bullet speed/ direction is random, and bullets 
		 * stay in frame, they dont exit frame so player must dodge them Missile update needs to be moves to gameStateLevel_ like enemy movement bounds were
		 */
		h = Math.random() * 0.25;
		v = Math.random() * 0.35 + JsonUtil.parse("paraConfig.json").get(GameParameters.BACKGROUND_SPEED)/10.0;
		if(Math.random()*51 < 25)
		{
			missile.setSpeed(h,v);
			if(missile.getX() <= 0 || missile.getX() >= DemoGameEngine.WIDTH-((missile.getWidth())))
			{
				missile.setSpeed(-h, v);		
			}
		}
		else{ 
			missile.setSpeed(-h,v);
			if(missile.getX() <= 0 || missile.getX() >= DemoGameEngine.WIDTH-((missile.getWidth())))
			{
				missile.setSpeed(h, v);		
			}
		}
	}

	public double enemyHP()
	{
		Configuration.ENEMY_HP = 3.5;
		return hp = 3.5;
	}
	public void enemyHP(Enemy enemy)
	{
		double hp = 3.5;
		enemy.setHP(hp);
	}
	public double getState()
	{
		return 5.0;
	}
}
