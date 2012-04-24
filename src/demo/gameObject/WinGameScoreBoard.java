package demo.gameObject;


import java.awt.Graphics2D;

import api.background.TopDownImageBackground;
import api.game.TopDownGameEngine;
import api.gameObject.ScoreBoardGameObject;
import api.state.DefaultFinishGameState;
import demo.collisionSystem.EnemyBulletCollision;
import demo.game.DemoGameEngine;

public class WinGameScoreBoard extends ScoreBoardGameObject {

	TopDownImageBackground mainMenuTitle;

	public WinGameScoreBoard(TopDownGameEngine parent) {
		super(parent);
		myState = new DefaultFinishGameState(parent, this);
	}

	@Override
	public void initResources() {
		mainMenuTitle = new TopDownImageBackground(
				getImage("images/menu/title.png"), DemoGameEngine.WIDTH,
				DemoGameEngine.HEIGHT);
	}

	@Override
	public void render(Graphics2D g) {
		mainMenuTitle.render(g);
		fontManager.getFont("FPS Font").drawString(g, "YOU WIN THE GAME ", 20,
				DemoGameEngine.HEIGHT / 2 - 50);
		fontManager.getFont("FPS Font").drawString(g,
				"YOU KILLED " + EnemyBulletCollision.destroyed + " ENEMIES",
				20, DemoGameEngine.HEIGHT / 2);
	}

}
