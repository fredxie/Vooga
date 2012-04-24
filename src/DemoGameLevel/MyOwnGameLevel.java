package DemoGameLevel;

import game.TopDownGameEngine;
import gameLevel.GameLevel;

import java.awt.Graphics2D;
import java.util.List;

import state.api.DefaultLastLevelState;

import levelEditor.Load;

import collisionSystem.EnemyBulletCollision;

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
