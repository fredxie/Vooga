package ai;
import element.*;
import game.*;
import collision.*;
import demo.*;
import game.Configuration;
import java.util.*;

import com.golden.gamedev.object.Timer;
import element.Missile;
public class Level4 implements TopDownBehavior
{
	/*
	 * timers don't work as i thought they did. Need to change this to get them to work
	 */
	private Timer timer = new Timer(400);
	private boolean timera = false;
	double d,h;


	public void movement(Enemy enemy)
	{
		timer.refresh();
		if(timer.getCurrentTick() == 400){
			timera = true;
		}
		if(timera == true && ((Math.random() * 50) < 10))
		{
			enemy.setSpeed(Math.random() * 0.26,Math.random()*0.26);
			timera = false;
			timer.refresh();
		}
		else if (timera == true && ((Math.random() * 50) >= 10))
		{
			enemy.setSpeed(0.2,0.1);
			timera = false;
			timer.refresh();
		}
		double x = enemy.getHorizontalSpeed();
		double y = enemy.getVerticalSpeed();
		if (enemy.getX() <= 0 || enemy.getX() >= DemoGameEngine.WIDTH-((enemy.getWidth())/2)){
			enemy.setSpeed(-x,y);
		}
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
		missile.setSpeed(Math.random() * 0.26,Math.random()*0.26);
	}
	public double enemyHP()
	{
		Configuration.ENEMY_HP = 3.0;
		return h = 3.0;
	}
//	public void enemyHP(Enemy enemy)
//	{
//		double h = 3.0;
//		enemy.setHP(h);
//	}
}
