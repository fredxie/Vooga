package state.api;

/**
 * @author Jiawei Shi
 */

import java.util.List;

import game.TopDownGameEngine;
import gameLevel.GameLevel;
import gameObject.api_GameObject.TopDownGameManager;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;

import configuration.api.GameParameters;
import configuration.api.Key;
import configuration.api.KeyAnnotation;
import configuration.api.KeyConfig;
import configuration.api.KeyPressedSubject;
import configuration.api.SystemKeyPressedObserver;

public abstract class State implements KeyConfig{
	private int stateID;
	protected GameObject myGameObject;
	protected GameEngine myGameEngine;
	
	private List<Key> keyList;
	public SystemKeyPressedObserver keyPressedObserver;

	public State(TopDownGameEngine parent, GameObject game) {
		myGameEngine = parent;
		myGameObject = game;
	}
	
	public void setKeyList(List<Key> list) {
		keyList = list;
	}

	public List<Key> getKeyList() {
		return keyList;
	}

	public void setStateID(int name) {
		stateID = name;
	}

	public int getStateID() {
		return stateID;
	}

	public void activateByPressedButton(int keyPress, int gameID) {
		if (myGameEngine.keyDown(keyPress)) {
			TopDownGameManager.setCurrentGameID(gameID);
			myGameObject.finish();
		}
	}
	
	public abstract void update(long arg0);

}
