package hud;

import collisionSystem.LifeDecreaseCollision;

public class ScoreInfo implements HUDInfo {
	public ScoreInfo() {}
	
	@Override
	public String getString(Object obj) {
//		EnemyFighterBulletCollision col = (EnemyFighterBulletCollision) obj;
		return " " + LifeDecreaseCollision.destroyed; //* col.scoreRatio;
	}
}
