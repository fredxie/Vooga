package keyconfiguration;

import com.golden.gamedev.GameObject;

import configuration.GameParameters;

import element.Fighter;

/**
 * 
 * @author Ran Zhang
 * 
 */
public class Key {
	private int keyValue;
	private GameParameters action;
	private KeyObserver observer;
	private GameObject myGame;

	public Key(int value, GameParameters actionName, Fighter player, GameObject game) {
		keyValue = value;
		action = actionName;
		observer = new KeyObserver(player);
		myGame = game;
	}

	public boolean isKeyDown() {
		if (myGame.keyDown(keyValue))
			return true;
		return false;
	}

	public GameParameters getAction() {
		return action;
	}

	public int getValue() {
		return keyValue;
	}

	public void notifyObserver(long elapsedTime) {
		observer.getActoinMethods(action, elapsedTime);
	}

}