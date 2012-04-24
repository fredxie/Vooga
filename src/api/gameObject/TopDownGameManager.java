package api.gameObject;

import java.util.HashMap;
import api.game.TopDownGameEngine;
import com.golden.gamedev.GameObject;

/**
 * This class stores the gameID and game objects for the whole game. All the
 * transitions between game objects can be done by set a new gameID to this
 * class. The TopDownGameEngine listens to the current gameID instantly.
 * 
 * @param GAMEBEGIN
 *            the begin of the game ID section assigned to OptionGameObjects,
 *            including menu and pause
 * @param GAMELEVELBEGIN
 *            the begin of the game ID section assigned to the gameLevels
 * @param SCOREBOARD
 *            the begin of the game ID section assigned to scoreboard game
 *            objects
 * @param map
 *            the Hashmap that stores the game objects and game IDs
 * @param currentGameID
 *            the game ID for the current game object
 * @param previousGameID
 *            the game ID for the previous game object
 * @param initialGameID
 *            the game ID for the initial game object
 * 
 * @author Larry
 * 
 */
public class TopDownGameManager {

	public static int GAMEBEGIN = 0;
	public static int GAMELEVELBEGIN = 100;
	public static int SCOREBOARD = 50;

	private static HashMap<Integer, GameObject> map;
	private static int currentGameID;
	private static int initialGameID;
	private static int previousGameID;

	public static void initManager(TopDownGameEngine e) {
		map = new HashMap<Integer, GameObject>();
	}

	/**
	 * Set the game ID for the initial game object
	 * 
	 * @param i
	 *            initial game ID
	 */
	public static void setInitialGameID(int i) {
		initialGameID = i;
		currentGameID = i;
	}

	/**
	 * Add new game objects and its game ID to the map
	 * 
	 * @param id
	 *            game ID assigned to the game object
	 * @param game
	 *            game object
	 */
	public static void addNewGameObject(int id, GameObject game) {
		map.put(id, game);
	}

	/**
	 * Get the game object
	 * 
	 * @return the game object assigned with the current game ID
	 */
	public static GameObject getCurrentGameObject() {
		return map.get(currentGameID);
	}

	/**
	 * Get the game object according to the game ID
	 * 
	 * @param gameID
	 * @return game object assigned with the input game ID
	 */
	public static GameObject getGameObject(int gameID) {
		return map.get(gameID);
	}

	/**
	 * Get the current game ID
	 * 
	 * @return current game ID
	 */
	public static int getCurrentGameID() {
		return currentGameID;
	}

	/**
	 * Set the current game ID. Also store the game ID as the previous game ID
	 * 
	 * @param id game ID
	 */
	public static void setCurrentGameID(int id) {
		previousGameID = currentGameID;
		currentGameID = id;
	}

	/**
	 * Get the initial game ID
	 * 
	 * @return initial game ID
	 */
	public static int getInitialGameID() {
		return initialGameID;
	}

	/**
	 * Get the previous game ID
	 * 
	 * @return previous game ID
	 */
	public static int getPreviousGameID() {
		return previousGameID;
	}

}
