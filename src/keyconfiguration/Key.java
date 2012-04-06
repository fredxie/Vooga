package keyconfiguration;

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

	private static long LATENCY = 10;
	private long lastUpdate = 0;
	private boolean[] isValid;
	private String[] values;
	private boolean isInitial = true;


	public Key(int value, String actionName, Fighter player, GameObject game) {
		keyValue = value;
		// values = keyValue.split(",");
		// isValid = new boolean[values.length];
		// invalidate();
		action = actionName;
		observer = new KeyObserver(player);
		myGame = game;
	}

	private void invalidate() {
		isInitial = true;
		for (int i = 0; i < isValid.length; i++) {
			isValid[i] = false;
		}
	}

	public boolean isKeyDown() {

		// if(values.length == 1){
		// if (myGame.keyDown(Integer.parseInt(values[0]))){
		// return true;
		// }
		// }
		// if(values.length > 1){
		// for(int i = 0; i < values.length; i++){
		// if(isInitial){
		// lastUpdate = milliSec;
		// isInitial = false;
		// }
		// if(myGame.keyDown(Integer.parseInt(values[i]))){
		// if((milliSec - lastUpdate) > LATENCY){
		// invalidate();
		// return false;
		// }
		// isValid[i] = true;
		// lastUpdate = milliSec;
		// if(i > 0){
		// for(int j = 0; j < i; j++){
		// if(!isValid[j]){
		// invalidate();
		// return false;
		// }
		// }
		// }
		// }
		// }
		// boolean keyDown = true;
		// for(boolean valid : isValid){
		// keyDown &= valid;
		// }
		// if(keyDown){
		// invalidate();
		// return true;
		// }else{
		// return false;
		// }
		// }
		// return false;
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