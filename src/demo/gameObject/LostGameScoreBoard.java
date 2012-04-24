package demo.gameObject;


import java.awt.Graphics2D;

import api.game.TopDownGameEngine;
import api.gameObject.ScoreBoardGameObject;
import api.gameObject.TopDownGameManager;
import api.state.DefaultFinishGameState;
import background.TopDownImageBackground;
import demo.collisionSystem.EnemyBulletCollision;
import demo.game.DemoGameEngine;

public class LostGameScoreBoard extends ScoreBoardGameObject {
	TopDownImageBackground mainMenuTitle;

	public LostGameScoreBoard(TopDownGameEngine arg0) {
		super(arg0);
		myState = new DefaultFinishGameState(arg0, this);
	}

	public void initResources() {
		mainMenuTitle = new TopDownImageBackground(
				getImage("images/menu/title.png"), DemoGameEngine.WIDTH,
				DemoGameEngine.HEIGHT);
	}

	public void render(Graphics2D g) {
		mainMenuTitle.render(g);
		fontManager.getFont("FPS Font").drawString(
				g,
				"YOU LOST IN THE LEVEL "
						+ (TopDownGameManager.getPreviousGameID()
								- TopDownGameManager.GAMELEVELBEGIN + 1), 20,
				DemoGameEngine.HEIGHT / 2 - 50);
		fontManager.getFont("FPS Font").drawString(g,
				"YOU KILLED " + EnemyBulletCollision.destroyed + " ENEMIES",
				20, DemoGameEngine.HEIGHT / 2);
	}

}
