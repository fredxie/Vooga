package ai;
import element.*;
 
import element.Bullet;
import game.*;
import collision.*;
import demo.*;
import demo.DemoEnemy;
import game.Configuration;
import java.util.*;

// basic functionality for level 1, starts with standard weapon, one directional movement, slow fire rate, reduced damage
// this corresponds to level 1 easy
public class Level1 implements TopDownBehavior
{
	double d,h;
	public void movement(Enemy enemy)
	{
		enemy.setSpeed(0,0.08);
	}
//	@Override
	public void fireRate(Enemy enemy)
	{
		enemy.setRefireRate(1200);
	}
	public double enemyDamage()
	{
		Configuration.ENEMY_WEAPON_DAMAGE = .25;
		return d = 0.25;
	}
//	@Override
//	public void weaponDamage(Bullet bullet)
//	{
//		bullet.setDamage(.5);
//	}
	public void weaponSpeed(Bullet bullet)
	{	
		bullet.setHorizontalSpeed(0);
		bullet.setVerticalSpeed(.15);
	}
//	@Override
	public double enemyHP()
	{
		Configuration.ENEMY_HP = 1.0;
		return h = 1.0;
	}
//	public void enemyHP(Enemy enemy)
//	{
//		double h = 1.0;
//		enemy.setHP(h);
//	}
}
