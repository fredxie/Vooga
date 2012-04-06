package ai;
import element.Enemy;
import element.Fighter;
import element.Bullet;
import game.*;
import collision.*;
import demo.*;
import java.util.*;

public class StrategyChanger 
{
	Fighter fighter;
	Enemy enemy;
	Bullet enemyBullet;
	double d;
	double h;
	{	
	if(fighter.getHP() <= .25)
	{
		hpLimit.movement(enemy);
		hpLimit.fireRate(enemy);
		hpLimit.enemyHP(h);
		hpLimit.enemyDamage(d);
//		hpLimit.weaponDamage(enemyBullet);
//		hpLimit.weaponSpeed(enemyBullet);
	}
	
	
	}

}
