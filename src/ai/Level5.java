package ai;
import element.*; 
import game.*;
import collision.*;
import demo.*;
import game.Configuration;
import java.util.*;

import com.golden.gamedev.object.Timer;

public class Level5 implements TopDownBehavior
{
	private Timer timer = new Timer(3200);
	private boolean timera = false;
	
	private Timer timer2 = new Timer(400);
	private Timer timer3 = new Timer(800);
	private Timer timer4 = new Timer(2000);
	boolean timerb = true;
	boolean timerc = true;
	boolean timerd = true;
	double d,h;

	public void movement(Enemy enemy)
	{
		double h = enemy.getHorizontalSpeed();
		double y = enemy.getVerticalSpeed();
		int x = (int) (Math.random()*51);
		timer.refresh();
		if(timer.getCurrentTick() == 3200){
			timera = true;
		}
		if(timera == true && x < 10)
		{
			enemy.setSpeed(Math.random() * 0.26,Math.random()*0.26);
			timera = false;
		}
		else if(timera == true && x > 30)
		{
			enemy.setSpeed(0.2,0.05);
			timera = false;
		}
		else if(timera == true && x >= 10 && x <=30)
		{
			timera = false;
			timerb = false;
			timer2.refresh();
			while(timerb == false){ 
				enemy.setSpeed(-.05,.05);
//				if (enemy.getX() <= 0)
//				{
//					enemy.setSpeed(.05,.05);
//				}
//				if (enemy.getX() >= DemoGameEngine.WIDTH-((enemy.getWidth())/2))
//				{
//					enemy.setSpeed(-.05,.05);
//				}
			}
			if(timerb == true){
				timerc = false;
				timer3.refresh();
				while(timerc == false)
				{
					enemy.setSpeed(-.05,-.07);
//					if (enemy.getX() <= 0)
//					{
//						enemy.setSpeed(.05,-.07);
//					}
//					if (enemy.getX() >= DemoGameEngine.WIDTH-((enemy.getWidth())/2))
//					{
//						enemy.setSpeed(-.05,.07);
//					}
				}
			}
			if(timerb == true && timerc == true){
				timerd = false;
				timer4.refresh();
				enemy.setSpeed(0,.1);
			}
		}
//		if (enemy.getX() <= 0){
//			enemy.setSpeed(0.2,0.05);
//		}
//		if (enemy.getX() >= DemoGameEngine.WIDTH-((enemy.getWidth())/2))
//		{
//			enemy.setSpeed(-0.2, 0.05);
//		}
		if (enemy.getX() <= 0 || enemy.getX() >= DemoGameEngine.WIDTH-((enemy.getWidth())/2)){
			enemy.setSpeed(-h,y);
		}
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
	public void weaponSpeed(Bullet bullet)
	{	
		/*
		 * in this level, the hypothetical final level on hard, bullet speed/ direction is random, and bullets 
		 * stay in frame, they dont exit frame so player must dodge them. 
		 */
		double h = Math.random() * 0.25;
		double v = Math.random() * 0.35;
		if(Math.random()*51 < 25){
			bullet.setSpeed(h,v);
		}
		else{ 
			bullet.setSpeed(-h,v);
		}
		if(bullet.getX() <= 0 || bullet.getX() >= DemoGameEngine.WIDTH-((bullet.getWidth())/2)){
			bullet.setSpeed(-h,v);
		}
	}

	public double enemyHP()
	{
		Configuration.ENEMY_HP = 3.5;
		return h = 3.5;
	}
	public void enemyHP(Enemy enemy)
	{
		double h = 3.5;
		enemy.setHP(h);
	}
}
