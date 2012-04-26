package api.state;

import java.util.List;

import api.configuration.Key;
import api.configuration.KeyConfig;
import api.configuration.SystemKeyPressedObserver;
import api.game.TopDownGameEngine;
import api.gameObject.TopDownGameManager;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;

/**
 * This class performs as the super class for all the state classes Includes the
 * state transitions between different game objects
 * 
 * @param stateID
 *            gameID of the current state
 * @param myGameObject
 *            the game object assigned with the current state
 * @param myGameEngine
 *            game engine for the whole project
 * @param keyList
 *            the list of keys
 * @param keyPressedObserver
 *            observer of key config
 * 
 * @author Jiawei Shi
 * 
 */
public abstract class State implements KeyConfig {
	private int stateID;
	protected GameObject myGameObject;
	protected GameEngine myGameEngine;

	private List<Key> keyList;
	protected SystemKeyPressedObserver keyPressedObserver;

	public State(TopDownGameEngine parent, GameObject game) {
		myGameEngine = parent;
		myGameObject = game;
	}

	/**
	 * Set the key list
	 */
	public void setKeyList(List<Key> list) {
		keyList = list;
	}

	/**
	 * Get the current key list
	 * 
	 * @return keyList
	 */
	public List<Key> getKeyList() {
		return keyList;
	}

	/**
	 * Set the gameID assigned to the current state
	 * 
	 * @param game
	 *            ID
	 */
	public void setStateID(int name) {
		stateID = name;
	}

	/**
	 * Get the game ID assigned to the current state
	 * 
	 * @return stateID
	 */
	public int getStateID() {
		return stateID;
	}

	/**
	 * The state transition is triggered if the keyPress is made. Set the gameID
	 * to the TopDownGameManager
	 * 
	 * @param keyPress
	 * @param gameID
	 */
	public void activateByPressedButton(int keyPress, int gameID) {
		if (myGameEngine.keyDown(keyPress)) {
			TopDownGameManager.setCurrentGameID(gameID);
			myGameObject.finish();
		}
	}

	/**
	 * Update the current state. Performs as the state transition
	 * 
	 * @param arg0
	 */
	public abstract void update(long arg0);

}
