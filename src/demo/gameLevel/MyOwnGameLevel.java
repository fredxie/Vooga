package demo.gameLevel;

import java.awt.Graphics2D;
import java.io.File;
import java.util.List;

import levelEditor.LevelEditorUtil;
import levelEditor.Load;
import api.game.TopDownGameEngine;
import api.gameLevel.GameLevel;
import api.state.DefaultLastLevelState;
import api.util.LoadUtil;
import demo.collisionSystem.EnemyBulletCollision;
import demo.levelTransition.DemoLevelTransition;

public class MyOwnGameLevel extends GameLevel {

	public List<List<Object>> list;

	public MyOwnGameLevel(TopDownGameEngine parent) {
		super(parent);
		myState = new DefaultLastLevelState(parent, this);
		levelInit = new MyOwnGameLevelInit(this);
		levelUpdate = new DemoLevelUpdate1(this);
		levelTransition = new DemoLevelTransition(this);
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
