package gameObject;

import game.TopDownGameEngine;

import java.awt.Graphics2D;

import demo.DemoGameEngine;

public abstract class GameLevel extends TopDownGameObject {

	public boolean gameOver = false;
	public String levelRequirement;
	public static int Level;

	public GameLevel(TopDownGameEngine parent) {
		super(parent);
	}

	public abstract boolean levelComplete();// level complete requirement

	public abstract void gameRender(Graphics2D g, String levelRequirement);

	public abstract void betweenLevelsRender(Graphics2D g, int nextLevelNum);

	public static int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		Level = level;
	}

	public void gameOverRender(Graphics2D g) {
		fontManager.getFont("FPS Font").drawString(g,
				"GAME OVER! PRESS ESC TO QUIT", 20, DemoGameEngine.HEIGHT / 2);
	}

}
