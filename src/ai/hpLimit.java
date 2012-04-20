package ai;
import element.Missile;
import demo.DemoGameEngine;

import element.Missile;
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
	}

	public void fireRate(Enemy enemy){
		int rate = enemy.getRefireRate();
		rate = rate + 150;
		enemy.setRefireRate(rate);		
	}

//	public static void weaponDamage(Missile missile)
//	{
//		double x = missile.getDamage();
//		x = x/2;
//		missile.setDamage(x);
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
	public void weaponSpeed(Missile missile)
	{
		double x = missile.getHorizontalSpeed();
		double y = missile.getVerticalSpeed();
		if(x > 0)
		{
			x = x * .5;
			missile.setHorizontalSpeed(x);
		}
		y = y * 0.75;
		missile.setVerticalSpeed(y);
	}
//	public static void enemyHP(Enemy enemy)
//	{
//		double h = enemy.getHP();
//		enemy.setHP(h);
//	}
	public double getState()
	{
		return 0;// setting as 0 since gamestate always starts at 1 and never reaches 0, these arent levels but ai changes based on changes in the game
	}
}
