package ai;

import demo.DemoGameEngine;
import element.Bullet;
import element.Enemy;
import game.Configuration;
/*
 * hp limit activate when player hp falls below a certain level. Rather then making the game tougher
 * it makes the game slightly easier to help the player. It won't activate until hp is almost gone
 */
public class hpLimit implements TopDownBehavior
{
	double d,h;
//	@Override
	public void movement(Enemy enemy)
	{
		double hSpeed = enemy.getHorizontalSpeed();
		double vSpeed = enemy.getVerticalSpeed();
		if (hSpeed > 0.05)
		{
			hSpeed = hSpeed - .03;
		}
		if( vSpeed > .08){
			vSpeed = vSpeed - .02; 
		}
		enemy.setSpeed(hSpeed,vSpeed);
		if (enemy.getX() <= 0){
			enemy.setSpeed(-hSpeed,vSpeed);
		}
		if (enemy.getX() >= DemoGameEngine.WIDTH-((enemy.getWidth())/2))
		{
			enemy.setSpeed(-hSpeed, vSpeed);
		}
	}
//	@Override
	public void fireRate(Enemy enemy){
		int rate = enemy.getRefireRate();
		rate = rate + 150;
		enemy.setRefireRate(rate);		
	}
//	@Override
//	public static void weaponDamage(Bullet bullet)
//	{
//		double x = bullet.getDamage();
//		x = x/2;
//		bullet.setDamage(x);
//	}
	public double enemyDamage()
	{
		double a = Configuration.ENEMY_WEAPON_DAMAGE;
		if(a > .5 && a < 2.5){
			d = a - .5;
		}
		else if (a >= 2.5){
			d = a - 1.0;
		}
		else if (a <= .5){
			d = a;
		}
		return d;
	}
	public double enemyHP()
	{
		double x = Configuration.ENEMY_HP;
		h = x - .5;
		Configuration.ENEMY_HP = h;
		return h;
	}
	public void weaponSpeed(Bullet bullet)
	{
		double x = bullet.getHorizontalSpeed();
		double y = bullet.getVerticalSpeed();
		if(x > 0)
		{
			x = x/2;
			bullet.setHorizontalSpeed(x);
		}
		y = y * 0.75;
		bullet.setVerticalSpeed(y);
	}
//	public static void enemyHP(Enemy enemy)
//	{
//		double h = enemy.getHP();
//		enemy.setHP(h);
//	}
}
