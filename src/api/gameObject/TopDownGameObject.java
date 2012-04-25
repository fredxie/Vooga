package api.gameObject;

import java.awt.Graphics2D;

import api.game.TopDownGameEngine;
import api.state.State;

import com.golden.gamedev.GameObject;

/**
 * 
 * This class is the game object for top down games. Developers use this to
 * design their own game object.
 * 
 * @param myState
 *            state of current game object
 * 
 */
public abstract class TopDownGameObject extends GameObject {
	protected State myState;

	public TopDownGameObject(TopDownGameEngine parent) {
		super(parent);
	}

	/**
	 * set the state of current game object
	 * 
	 * @param gameState
	 *            state of game object
	 */
	public void setGameState(State gameState) {
		myState = gameState;
	}

	/**
	 * get the state of current game object
	 * 
	 * @param gameState
	 *            state of game object
	 */
	public State getCurrentState() {
		return myState;
	}

	/**
	 * initialization
	 */
	public abstract void initResources();

	/**
	 * render
	 */
	public abstract void render(Graphics2D g);

	/**
	 * game object update
	 * 
	 * @param elapsedTime
	 */
	public void update(long elapsedTime) {
		myState.update(elapsedTime);
		innerStateUpdate(elapsedTime);
	}

	/**
	 * game level update
	 * 
	 * @param elapsedTime
	 */
	public abstract void innerStateUpdate(long elapsedTime);

}
