package api.state;

/**
 * @author Jiawei Shi
 */

import java.util.List;


import api.configuration.Key;
import api.configuration.KeyAnnotation;
import api.configuration.KeyConfig;
import api.configuration.KeyPressedSubject;
import api.configuration.SystemKeyPressedObserver;
import api.game.TopDownGameEngine;
import api.gameLevel.GameLevel;
import api.gameObject.TopDownGameManager;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;


public abstract class State implements KeyConfig {
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
