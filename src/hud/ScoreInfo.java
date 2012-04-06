package hud;

import collision.EnemyFighterBulletCollision;

public class ScoreInfo implements HUDInfo {
	public ScoreInfo() {}
	
	@Override
	public String getString(Object obj) {
		EnemyFighterBulletCollision col = (EnemyFighterBulletCollision) obj;
		return " " + col.destroyed * col.scoreRatio;
	}
}
