package ai;

import demo.element.Missile;
import api.element.Enemy;

public interface EnemyTopDownBehavior {
	abstract int getState();

	abstract void enemy_Changes(Enemy enemy);

	abstract void weapon_Changes(Missile missile);
}
// abstract public void weaponDamage(Bullet bullet);
// abstract public void enemyHP(Enemy enemy); 