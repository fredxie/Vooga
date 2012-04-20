package ai;

import element.Bullet;
import element.Missile;
import element.Enemy;

public interface EnemyTopDownBehavior 
{	
	abstract int getState();
	abstract void enemy_Changes(Enemy enemy);
	abstract void weapon_Changes(Missile missile);
}
//abstract public void weaponDamage(Bullet bullet);
//abstract public void enemyHP(Enemy enemy); 