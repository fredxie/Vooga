package ai;

import demo.DemoGameEngine;
import element.Bullet;
import element.Enemy;
import game.Configuration;
/*
 * hp limit activate when player hp falls below a certain level. Rather then making the game tougher
 * it makes the game slightly easier to help the player. It won't activate until hp is almost gone
 */
public class hpLimit //extends TopDownLevel
{
//	@Override
	public static void movement(Enemy enemy)
	{
		double hSpeed = enemy.getHorizontalSpeed();
		double vSpeed = enemy.getVerticalSpeed();
		if (hSpeed >= 0.05)
		{
			hSpeed = hSpeed - .03;
		}
		vSpeed = vSpeed - .02; 
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
	public static void fireRate(Enemy enemy){
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
	public static void enemyDamage(double d)
	{
		d = 0.5;
		Configuration.ENEMY_WEAPON_DAMAGE = d;
	}
	public static void enemyHP(double h)
	{
		h = 1.0;
		Configuration.ENEMY_HP = h;
	}
//	public static void weaponSpeed(Bullet bullet)
//	{
//		double x = bullet.getHorizontalSpeed();
//		double y = bullet.getVerticalSpeed();
//		if(x > 0)
//		{
//			x = x/2;
//			bullet.setHorizontalSpeed(x);
//		}
//		y = y * 0.75;
//		bullet.setVerticalSpeed(y);
//	}
//	public static void enemyHP(Enemy enemy)
//	{
//		double h = enemy.getHP();
//		enemy.setHP(h);
//	}
}
