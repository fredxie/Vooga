
package ai;
import element.*;

import element.Missile;
import element.Bullet;
import game.*;
import collision.*;
import demo.*;
import game.Configuration;
import java.util.*;

// basic functionality for level 1, starts with standard weapon, one directional movement, slow fire rate, reduced damage
// this corresponds to level 1 easy
public class Level1 implements EnemyTopDownBehavior
{
	double d,h;
	public void enemy_Changes(Enemy enemy)
	{
		enemy.setSpeed(0,0.13);
		enemy.setRefireRate(1200);
		Configuration.ENEMY_HP = 1.0;
	}

	
	public void weapon_Changes(Missile missile)
	{
		Configuration.ENEMY_WEAPON_DAMAGE = .25;
		missile.setHorizontalSpeed(0);
		missile.setVerticalSpeed(.15);
	}
	public int getState()
	{
		return 1;
	}

//	public void weaponDamage(Missile missile)
//	{
//		missile.setDamage(.5);
//	}
	
//	public void enemyHP(Enemy enemy)
//	{
//		double h = 1.0;
//		enemy.setHP(h);
//	}
}

