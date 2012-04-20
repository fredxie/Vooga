<<<<<<< HEAD
package ai;

import element.Bullet;
import element.Missile;
import element.Enemy;

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
=======
package ai;

import element.Bullet;
import element.Missile;
import element.Enemy;

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
>>>>>>> ada42b2f157034c49af47fe8c2b0fb0d4d6625ad
