package demo.HUD;

import api.element.Enemy;
import api.hud.DisplayText;


public class EnemyHPText extends DisplayText {
	private Enemy myEnemy;
	
	public EnemyHPText(Enemy enemy) {
		super();
		myEnemy = enemy;
	}
	
	@Override
	public String getString() {
		return " " + myEnemy.getHP();
	}
}
