package ai;
import element.*; 
import game.*;
import collision.*;
import demo.*;
import game.Configuration;
import java.util.*;

import com.golden.gamedev.object.Timer;

import element.Enemy;

/*
 * When the player gets x number of points, score limit increases the ai of the computer. This will happen
 * multiple times through the game depending on the score of the player, and can happen in any level, and in
 * addition to any other ai change.
 */
public class ScoreLimit extends TopDownLevel
{
	public void movement(Enemy enemy)
	{
		double hSpeed = enemy.getHorizontalSpeed();
		double vSpeed = enemy.getVerticalSpeed();
		hSpeed = hSpeed + .05;
		vSpeed = vSpeed + .02; // Vspeed incremented less, since it could happen several times and sprite leaving screen faster benifits player in a way;
		enemy.setSpeed(hSpeed,vSpeed);
		if (enemy.getX() <= 0){
			enemy.setSpeed(-hSpeed,vSpeed);
		}
		if (enemy.getX() >= DemoGameEngine.WIDTH-((enemy.getWidth())/2))
		{
			enemy.setSpeed(-hSpeed, vSpeed);
		}
	}
	public void fireRate(Enemy enemy){
		int rate = enemy.getRefireRate();
		rate = rate - 150;
		enemy.setRefireRate(rate);		
	}
	public void weaponDamage(Bullet bullet)
	{
		double x = bullet.getDamage();
		x = x + 0.5;
		bullet.setDamage(x);
	}
//	public void enemyDamage(double d)
//	{
//		d = Configuration.ENEMY_WEAPON_DAMAGE;
//		d = d + .5;
//	}
	public void weaponSpeed(Bullet bullet)
	{
		double x = bullet.getHorizontalSpeed();
		double y = bullet.getVerticalSpeed();
		x = x * 1.3;
		bullet.setHorizontalSpeed(x);
		y = y * 1.3;
		bullet.setVerticalSpeed(y);
	}
//	public void enemyHP(double h) {
//		
//	}
	public void enemyHP(Enemy enemy)
	{
		double h = enemy.getHP();
		h = h + .25;
		enemy.setHP(h);
	}
}
