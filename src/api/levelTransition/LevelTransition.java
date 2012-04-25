package api.levelTransition;

import java.awt.Graphics2D;

import api.gameLevel.GameLevel;

/**
 * this class is a level transition manager used for developers to design the
 * function parts of transition between two game levels
 * 
 * @param gl
 *            current game level
 * @author Chenbo Zhu
 * 
 */
public abstract class LevelTransition {
	public GameLevel gl;

	public LevelTransition(GameLevel gl) {
		this.gl = gl;
	}

	/**
	 * game over method
	 */
	public abstract void gameOver();

	/**
	 * render after level completed
	 * 
	 * @param g
	 */
	public abstract void levelCompleteRender(Graphics2D g);

	/**
	 * render after game over
	 * 
	 * @param g
	 */
	public abstract void gameOverRender(Graphics2D g);
}
