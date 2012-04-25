package api.gameObject;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import api.configuration.KeyAnnotation;
import api.game.TopDownGameEngine;
import api.state.State;

import com.golden.gamedev.GameObject;

/**
 * This class extends the game object Perform as the super class of game objects
 * with options
 * 
 * @param myState
 *            the state class of the current game object
 * @param option
 *            the current option selected by the user
 * @param options
 *            the list of all the options
 * 
 * @author Jiawei Shi
 */

public abstract class OptionGameObject extends GameObject {
	protected State myState;
	public int option;
	public ArrayList<String> options;

	public OptionGameObject(TopDownGameEngine parent) {
		super(parent);
		options = new ArrayList<String>();
		setOptionList();
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
	 * Update the inner state and transitions
	 */
	public void update(long elapsedTime) {
		myState.update(elapsedTime);
		setFinish(bsInput.getKeyPressed(), KeyEvent.VK_ESCAPE);
	}

	/**
	 * Get the state object assigned to the current game object
	 * 
	 * @return state object
	 */
	public State getCurrentState() {
		return myState;
	}

	/**
	 * Get the number of options assigned to the game object
	 * 
	 * @return size of option list
	 */
	public int getOptionNumber() {
		return options.size();
	}

	/**
	 * Add a new option to the optoion list
	 * 
	 * @param newOption
	 */
	public void addOption(String newOption) {
		options.add(newOption);
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
		int y = Y_pos;
		for (String s : options) {
			fontManager.getFont("FPS Font").drawString(g, s, X_pos, y);
			y = y + interval;
		}

	}

	/**
	 * Arrow goes up when the user made the corresponding input
	 * 
	 * @param elapsedTime
	 */
	@KeyAnnotation(action = "SystemUp")
	public void optionArrowUp(long elapsedTime) {
		option--;
		if (option < 0)
			option = options.size() - 1;
	}

	/**
	 * Arrow goes down when the user made the corresponding input
	 * 
	 * @param elapsedTime
	 */
	@KeyAnnotation(action = "SystemDown")
	public void optionArrowDown(long elapsedTime) {
		option++;
		if (option > options.size() - 1)
			option = 0;
	}

	/**
	 * Set the triggering condition for the end of the current game object. If
	 * the key and the bsInput are the same, the current game object ends
	 * 
	 * @param bsInput
	 *            , the custom key for ending the game object
	 * @param key
	 *            , the key made by the user
	 */
	public void setFinish(int bsInput, int key) {
		if (bsInput == key) {
			finish();
		}
	}

	/**
	 * Set the state class for the game object
	 * 
	 * @param s
	 *            , state class
	 */
	public void setState(State s) {
		myState = s;
	}

	/**
	 * Get the current option
	 * 
	 * @return option
	 */
	public int getOption() {
		return option;
	}

	/**
	 * Initialize the game object. Extended by the sub-classes
	 */
	public abstract void initResources();

	/**
	 * Make the display of the game object. Extended by the sub-class
	 */
	public abstract void render(Graphics2D arg0);

	/**
	 * Initialize all the options included in the game object. Extended by the
	 * sub-class
	 */
	public abstract void setOptionList();

}
