package ai;
import element.Enemy;
import element.Missile;
import game.Configuration;

public class Level2 implements TopDownBehavior
{
	double d,h;
	
	public void movement(Enemy enemy)
	{
		double h = 0.1;
		double v = 0.13;
		enemy.setSpeed(h,v);	
	}
	
	public void fireRate(Enemy enemy)
	{
		enemy.setRefireRate(900);
	}
	public double enemyDamage()
	{
		Configuration.ENEMY_WEAPON_DAMAGE = 1.0;
		return d = 1.0;
	}

//	public void weaponDamage(Missile missile)
//	{
//		missile.setDamage(1.0);
//	}
	public void weaponSpeed(Missile missile)
	{	
		if(Math.random()*10 > 5)
		{
			missile.setHorizontalSpeed(.1);
		}
		else {
			missile.setHorizontalSpeed(-.1);
		}
		missile.setVerticalSpeed(.2);
	}

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
	public double getState()
	{
		return 2.0;
	}
}
