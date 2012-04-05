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

public class Level2 extends TopDownLevel
{
//	@Override
	public void movement(Enemy enemy)
	{
		enemy.setSpeed(0.1,0.13);	
		if (enemy.getX() <= 0){
			enemy.setSpeed(.1,0.13);
		}
		if (enemy.getX() >= DemoGameEngine.WIDTH-((enemy.getWidth())/2))
		{
			enemy.setSpeed(-.10, 0.13);
		}
	}
//	@Override
	public void fireRate(Enemy enemy)
	{
		enemy.setRefireRate(900);
	}
//	public void enemyDamage(double d)
//	{
//		d = 1.0;
//		Configuration.ENEMY_WEAPON_DAMAGE = d;
//	}
//	@Override
	public void weaponDamage(Bullet bullet)
	{
		bullet.setDamage(1.0);
	}
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
//	public void enemyHP(double h)
//	{
//		h = 2.0;
//		Configuration.ENEMY_HP = h;
//	}
	public void enemyHP(Enemy enemy)
	{
		double h = 2.0;
		enemy.setHP(h);
	}
}
