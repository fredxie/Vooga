package demo.gameLevel;

import java.awt.Graphics2D;

import api.game.TopDownGameEngine;
import api.gameLevel.GameLevel;
import api.state.DefaultLevelState;
import demo.collisionSystem.EnemyBulletCollision;
import demo.levelTransition.DemoLevelTransition;

public class GameLevel1 extends GameLevel {

	public GameLevel1(TopDownGameEngine parent) {
		super(parent);
		myState = new DefaultLevelState(parent, this);
		levelInit = new DemoLevelInit1(this);
		levelUpdate =new DemoLevelUpdate1(this);
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
