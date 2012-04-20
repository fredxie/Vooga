
package ai;

import element.Enemy;
import element.Missile;

public interface TopDownBehavior {
	abstract void movement(Enemy enemy);
	abstract public void fireRate(Enemy enemy);
//	abstract public void weaponDamage(Bullet bullet);
//	abstract public void enemyHP(Enemy enemy); 
	abstract double enemyHP();
	abstract double enemyDamage();
	abstract public void weaponSpeed(Missile missile);
	abstract double getState();
}

