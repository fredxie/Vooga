package hud;

import api.element.Enemy;

public class EnemyHPInfo implements HUDInfo {
	public EnemyHPInfo() {
	}

	@Override
	public String getString(Object obj) {
		Enemy enemy = (Enemy) obj;
		return " " + enemy.getHP();
	}
}
