package demo.HUD;

import api.hud.DisplayText;
import demo.collisionSystem.EnemyBulletCollision;


public class ScoreText extends DisplayText {
	public ScoreText() {
		super();
	}
	
	@Override
	public String getString() {
		return " " + EnemyBulletCollision.destroyed; 
	}
}
