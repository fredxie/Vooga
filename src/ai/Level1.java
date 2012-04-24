package ai;

import DemoElement.Missile;
import element.Enemy;

// basic functionality for level 1, starts with standard weapon, one directional movement, slow fire rate, reduced damage
// this corresponds to level 1 easy
public class Level1 implements TopDownBehavior {
	double d, h;

	public void movement(Enemy enemy) {
		enemy.setSpeed(0, 0.08);
	}

	public void fireRate(Enemy enemy) {
		enemy.setRefireRate(1200);
	}

	public double enemyDamage() {
		AI.ENEMY_WEAPON_DAMAGE = .25;
		return d = 0.25;
	}

	// public void weaponDamage(Missile missile)
	// {
	// missile.setDamage(.5);
	// }
	public void weaponSpeed(Missile missile) {
		missile.setHorizontalSpeed(0);
		missile.setVerticalSpeed(.15);
	}

	public double enemyHP() {
		AI.ENEMY_HP = 1.0;
		return h = 1.0;
	}

	// public void enemyHP(Enemy enemy)
	// {
	// double h = 1.0;
	// enemy.setHP(h);
	// }
	public double getState() {
		return 1.0;
	}
}
