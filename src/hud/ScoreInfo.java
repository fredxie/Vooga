package hud;

import DemoCollisioSystem.LifeDecreaseCollision;

public class ScoreInfo implements HUDInfo {
	public ScoreInfo() {}
	
	@Override
	public String getString(Object obj) {
//		EnemyFighterBulletCollision col = (EnemyFighterBulletCollision) obj;
		return " " + LifeDecreaseCollision.destroyed; //* col.scoreRatio;
	}
}
