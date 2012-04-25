package api.gameObject;

import java.awt.Graphics2D;
import java.util.ArrayList;
import api.state.State;
import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;

/**
 * This class extends the game object. Performs as the super class of game
 * objects display scores
 * 
 * @param myState the state class of the current game object
 * @param output the contents of the output
 * 
 * @author Jiawei Shi
 * 
 */
public abstract class ScoreBoardGameObject extends GameObject {
	protected State myState;
	ArrayList<String> output;

	public ScoreBoardGameObject(GameEngine parent) {
		super(parent);
		output = new ArrayList<String>();
	}

	/**
	 * Set the game state class for the game object
	 * 
	 * @param gameState
	 */
	public void setGameState(State gameState) {
		myState = gameState;
	}

	/**
	 * Add new content to the output list
	 * 
	 * @param s
	 */
	public void addOutputContent(String s) {
		output.add(s);
	}

	/**
	 * Set the layout for the options. Includes the start position, and interval
	 * 
	 * @param g
	 * @param X_pos
	 *            x-axis of the first option
	 * @param Y_pos
	 *            y-axis of the first option
	 * @param interval
	 *            interval between options
	 */
	public void setOptionLayout(Graphics2D g, int X_pos, int Y_pos, int interval) {
		for (String s : output) {
			System.out.println(s);
		}

		int y = Y_pos;
		for (String s : output) {
			fontManager.getFont("FPS Font").drawString(g, s, X_pos, y);
			y = y + interval;
		}

	}

	/**
	 * Update the current game object. Only incudes the game transitions.
	 */
	public void update(long arg0) {
		myState.update(arg0);
	}

	/**
	 * Initialize the game object. Extended by the sub-classes
	 */
	public abstract void initResources();

	/**
	 * Make the display of the game object. Extended by the sub-class
	 */
	public abstract void render(Graphics2D arg0);

}
