package api.game;


import api.gameObject.TopDownGameManager;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;

/**
 * This is the game engine of top down games.
 * @author Jiawei Shi
 */


public abstract class TopDownGameEngine extends GameEngine {
	{
		distribute = true;
	}

	public static int HEIGHT;
	public static int WIDTH;

	public TopDownGameEngine() {
		TopDownGameManager.initManager(this);
	}

	/**
	 * Initialize the game objects and game states.
	 */	
	public void initResources() {
		super.initResources();
		TopDownGameManager.initManager(this);
		addGameObjects();
		setInitialGameID();
	}
	
	/**
	 * Instantly watch the gameID from the TopDownGameManager
	 */

	public void update(long elapsedTime) {
		nextGameID = TopDownGameManager.getCurrentGameID();
	}
	
	/**
	 * Return new game object when the gameID is updated
	 */

	public GameObject getGame(int gameID) {
		return TopDownGameManager.getGameObject(nextGameID);
	}
	
	/**
	 * Add all the game objects and set them game IDs before the game begins
	 * Extended by concrete class
	 */

	public abstract void addGameObjects();
	
	/**
	 * Set the initial gameID for the game
	 * This will decide which game object is initially called 
	 */

	public abstract void setInitialGameID();

}
