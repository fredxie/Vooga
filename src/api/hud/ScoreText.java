package api.hud;

import demo.collisionSystem.LifeDecreaseCollision;


public class ScoreText extends DisplayText {
	public ScoreText() {
		super();
	}
	
	@Override
	public String getString() {
		return " " + LifeDecreaseCollision.destroyed; 
	}
}
