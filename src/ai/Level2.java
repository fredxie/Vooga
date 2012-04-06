package ai;
import element.*; 
import game.*;
import collision.*;
import demo.*;
import game.Configuration;

import java.awt.Graphics2D;
import java.util.*;
import com.golden.gamedev.*;
/* correspond to level 2 easy or level 1 hard.
 * fire rate increases slightly, movement becomes horizontal also.  
 */

public class Level2 implements TopDownBehavior
{
	double d,h;
//	@Override
	public void movement(Enemy enemy)
	{
		double h = 0.1;
		double v = 0.13;
		enemy.setSpeed(h,v);	
		if (enemy.getX() <= 0 || enemy.getX() >= DemoGameEngine.WIDTH-((enemy.getWidth())/2)){
			enemy.setSpeed(-h,v);
		}
	}
//	@Override
	public void fireRate(Enemy enemy)
	{
		enemy.setRefireRate(900);
	}
	public double enemyDamage()
	{
		Configuration.ENEMY_WEAPON_DAMAGE = 1.0;
		return d = 1.0;
	}
//	@Override
//	public void weaponDamage(Bullet bullet)
//	{
//		bullet.setDamage(1.0);
//	}
	public void weaponSpeed(Bullet bullet)
	{	
		if(Math.random()*10 > 5)
		{
			bullet.setHorizontalSpeed(.1);
		}
		else {
			bullet.setHorizontalSpeed(-.1);
		}
		bullet.setVerticalSpeed(.2);
	}
//	@Override
	public double enemyHP()
	{
		Configuration.ENEMY_HP = 2.0;
		return h = 2.0;
	}
	public void enemyHP(Enemy enemy)
	{
		double h = 2.0;
		enemy.setHP(h);
	}
//	public void movement(Enemy enemy)
//	{
////		double h = 0.1;
////		double v = 0.13;
//		enemy.setSpeed(.1,.13);	
//		if (enemy.getX() <= 0){
////			enemy.setSpeed(-h,v);
//			enemy.setSpeed(.1,.13);
//		}
//		if(enemy.getX() >= DemoGameEngine.WIDTH-((enemy.getWidth())/2)){
//			enemy.setSpeed(-.1,.13);
//		}
//	}
}
