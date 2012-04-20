
package ai;
import element.*; 
import element.Missile;
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

public class Level2 implements EnemyTopDownBehavior
{	
	public void enemy_Changes(Enemy enemy)
	{
		enemy.setSpeed(.1,.13);	
		enemy.setRefireRate(900);
		Configuration.ENEMY_HP = 2.0;
	}

	public void weapon_Changes(Missile missile)
	{	
		if(Math.random()*10 > 5)
		{
			missile.setHorizontalSpeed(.1);
		}
		else {
			missile.setHorizontalSpeed(-.1);
		}
		missile.setVerticalSpeed(.2);
		
		Configuration.ENEMY_WEAPON_DAMAGE = 1.0;
	}

	public int getState()
	{
		return 2;
	}
//	public void enemyHP(Enemy enemy)
//	{
//		double h = 2.0;
//		enemy.setHP(h);
//	}
//	public void weaponDamage(Missile missile)
//	{
//		missile.setDamage(1.0);
//	}
}

