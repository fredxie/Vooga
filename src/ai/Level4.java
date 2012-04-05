package ai;
import element.*;
import game.*;
import collision.*;
import demo.*;
import game.Configuration;
import java.util.*;

import com.golden.gamedev.object.Timer;

public class Level4 extends TopDownLevel
{
	private Timer timer = new Timer(400);
	private boolean timera = false;

//	@Override
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
//	@Override
	public void fireRate(Enemy enemy)
	{
		enemy.setRefireRate(600);
	}
//	public void enemyDamage(double d)
//	{
//		d = 2.0;
//		Configuration.ENEMY_WEAPON_DAMAGE = d;
//	}
//	@Override
	public void weaponDamage(Bullet bullet)
	{
		bullet.setDamage(2.0);
	}
	public void weaponSpeed(Bullet bullet)
	{	
		bullet.setSpeed(Math.random() * 0.26,Math.random()*0.26);
	}
//	@Override
//	public void enemyHP(double h)
//	{
//		h = 3.0;
//		Configuration.ENEMY_HP = h;
//	}
	public void enemyHP(Enemy enemy)
	{
		double h = 3.0;
		enemy.setHP(h);
	}
}
