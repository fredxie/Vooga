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
import element.Missile;
import element.TopDownBackground;
public class Level4 implements TopDownBehavior
{
	double d,hp,h,v;
	double x = Math.random() * 50;
	Timer timer;

	public void movement(final Enemy enemy)
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
						enemy.setSpeed(Math.random() * 0.26,Math.random()*0.26  + Configuration.BACKGROUND_SPEED );
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
	}

	public void fireRate(Enemy enemy)
	{
		enemy.setRefireRate(600);
	}
	public double enemyDamage()
	{
		Configuration.ENEMY_WEAPON_DAMAGE = 2.0;
		return d = 2.0;
	}

//	public void weaponDamage(Missile missile)
//	{
//		missile.setDamage(2.0);
//	}
	public void weaponSpeed(Missile missile)
	{	
		missile.setSpeed(Math.random() * 0.25,Math.random()*0.2 + Configuration.BACKGROUND_SPEED);
	}
	public double enemyHP()
	{
		Configuration.ENEMY_HP = 3.0;
		return hp = 3.0;
	}
//	public void enemyHP(Enemy enemy)
//	{
//		double h = 3.0;
//		enemy.setHP(h);
//	}
	public double getState()
	{
		return 4.0;
	}
}
