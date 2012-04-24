package api.levelTransition;


import java.awt.Graphics2D;

import api.gameLevel.GameLevel;

public abstract class LevelTransition {
	public GameLevel gl;

	public LevelTransition(GameLevel gl) {
		this.gl = gl;
	}

	public abstract void gameOver();

	public abstract void levelCompleteRender(Graphics2D g);

	public abstract void gameOverRender(Graphics2D g);
}
