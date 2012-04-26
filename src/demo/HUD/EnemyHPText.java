package demo.HUD;

import api.HUD.DisplayText;
import api.element.Enemy;


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
