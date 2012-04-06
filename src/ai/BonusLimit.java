package ai;

import com.golden.gamedev.object.Timer;

import game.Configuration;
import demo.DemoGameEngine;
import element.Bullet;
import element.Enemy;
import java.util.*;

public class BonusLimit implements TopDownBehavior
{
	private Timer timer1 = new Timer(400);
	private Timer timer2 = new Timer(800);
	private Timer timer3 = new Timer(2000);
	boolean timera = true;
	boolean timerb = true;
	boolean timerc = true;
	double d,h;
	
	public void movement(Enemy enemy)
	{
		double h;
		double v;
		timera = false;
		timer1.refresh();
		while(timera == false){ 
			h = -.05;
			v = .05;
			enemy.setSpeed(h,v);
			if (enemy.getX() <= 0 || enemy.getX() >= DemoGameEngine.WIDTH-((enemy.getWidth())/2))
			{
				enemy.setSpeed(-h,v);
			}
		}
		if(timera == true){
			timerb = false;
			timer2.refresh();
			while(timerb == false)
			{
				h = -.05;
				v = -.07;
				enemy.setSpeed(h,v);
				if (enemy.getX() <= 0 || enemy.getX() >= DemoGameEngine.WIDTH-((enemy.getWidth())/2))
				{
					enemy.setSpeed(-h,v);
				}
			}
		}
		if(timera == true && timerb == true){
			timerc = false;
			timer3.refresh();
			h = 0;
			v = .12;
			enemy.setSpeed(h,v);
		}
	}
	public void fireRate(Enemy enemy)
	{
		enemy.setRefireRate(500);
	}
	public double enemyDamage()
	{
		return d = 1.0;
	}
	public void weaponDamage(Bullet bullet)
	{
		bullet.setDamage(1.5);
	}
	public void weaponSpeed(Bullet bullet)
	{
		double x = bullet.getHorizontalSpeed();
		double y = bullet.getVerticalSpeed();
		x = x * 1.5;
		bullet.setHorizontalSpeed(x);
		y = y * 1.5;
		bullet.setVerticalSpeed(y);
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
}
