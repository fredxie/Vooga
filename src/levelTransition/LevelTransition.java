package levelTransition;

import gameLevel.GameLevel;

import java.awt.Graphics2D;

public abstract class LevelTransition {
	public GameLevel gl;

	public LevelTransition(GameLevel gl) {
		this.gl = gl;
	}

	public abstract void gameOver();

	public abstract void levelCompleteRender(Graphics2D g);

	public abstract void gameOverRender(Graphics2D g);
}
