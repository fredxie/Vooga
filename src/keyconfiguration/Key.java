package keyconfiguration;

import java.util.ArrayList;

import com.golden.gamedev.Game;
import com.golden.gamedev.GameObject;

import element.Fighter;

/**
 * 
 * @author Ran Zhang
 * 
 */
public class Key {
	private int keyValue;
	private String action;
	private KeyObserver observer;
	private GameObject myGame;
	private boolean[] isValid;

	public Key(int value, String actionName, Fighter player, GameObject game) {
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

	public String getAction() {
		return action;
	}

	public int getValue() {
		return keyValue;
	}

	public void notifyObserver(long elapsedTime) {
		observer.getActoinMethods(action, elapsedTime);
	}

}