
package state;


/**
 * @author Jiawei Shi
 */


import game.TopDownGameEngine;
import gameObject.GameLevel;
import gameObject.TopDownGameManager;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;


public abstract class State{
	private int stateID;
	protected GameObject myGameObject;
	protected GameEngine myGameEngine;
	
	public State(TopDownGameEngine parent,GameObject game) {
		myGameEngine = parent;
		myGameObject = game;
	}
	
	public void setStateID(int name){
		stateID = name;
	}

	public int getStateID(){
		return stateID;
	}
	
	public void activateByPressedButton(int keyPress, int gameID){
		if (myGameEngine.keyDown(keyPress)){
			//myGameEngine.nextGameID = gameID;
			TopDownGameManager.setCurrentGameID(gameID);
			myGameObject.finish();
		}
	}

	public abstract void update(long arg0);

	//public abstract void gameFinish(GameLevel game, long arg0);
}
