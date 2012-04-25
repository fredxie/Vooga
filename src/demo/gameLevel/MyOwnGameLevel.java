package demo.gameLevel;


import java.awt.Graphics2D;
import java.util.List;

import api.game.TopDownGameEngine;
import api.gameLevel.GameLevel;
import api.state.DefaultLastLevelState;

import demo.collisionSystem.EnemyBulletCollision;

import levelEditor.Load;

public class MyOwnGameLevel extends GameLevel {

	public List<List<Object>> list = Load.list;

	public MyOwnGameLevel(TopDownGameEngine parent) {
		super(parent);
		myState = new DefaultLastLevelState(parent, this);
	}

	public void initResources() {

	}

	public void innerStateUpdate(long elapsedTime) {

	}

	public void render(Graphics2D g) {
		playfield.render(g);
		gameRender(g);

	}

	public void gameRender(Graphics2D g) {
		fontManager.getFont("FPS Font").drawString(g, levelRequirement, 20, 15);
		fontManager
				.getFont("FPS Font")
				.drawString(
						g,
						"ENEMIES DESTROYED   " + EnemyBulletCollision.destroyed,
						20, 30);

	}

}
