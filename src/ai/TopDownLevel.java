package ai;

import element.Bullet;
import element.Enemy;

public abstract class TopDownLevel {
	abstract void movement(Enemy enemy);
	abstract public void fireRate(Enemy enemy);
	abstract public void weaponDamage(Bullet bullet);
	abstract public void enemyHP(Enemy enemy);
//	abstract public void enemyHP(double h);
//	abstract void enemyDamage(double d);
	abstract public void weaponSpeed(Bullet bullet);
}
