package demo.gameLevel;


import java.awt.Graphics2D;

import api.game.TopDownGameEngine;
import api.gameLevel.GameLevel;
import api.state.DefaultLastLevelState;
import demo.collisionSystem.EnemyBulletCollision;
import demo.levelTransition.DemoLevelTransition;


public class GameLevel2 extends GameLevel {

	public GameLevel2(TopDownGameEngine parent) {
		super(parent);
		myState = new DefaultLastLevelState(parent, this);
		levelInit = new DemoLevelInit2(this);
		levelUpdate =new DemoLevelUpdate2(this);
		levelTransition =new DemoLevelTransition(this);
	}

	public void render(Graphics2D g) {
		playfield.render(g);
		fontManager.getFont("FPS Font").drawString(g, levelRequirement, 20, 15);
		fontManager
				.getFont("FPS Font")
				.drawString(
						g,
						"ENEMIES DESTROYED   " + EnemyBulletCollision.destroyed,
						20, 30);
	
	}

}
