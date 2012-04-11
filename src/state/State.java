
package state;


/**
 * @author Jiawei Shi
 */


import game.TopDownGameEngine;
import gameObject.TopDownGameObject;

import com.golden.gamedev.GameEngine;


public abstract class State{
	private int stateID;
	protected TopDownGameObject myGameObject;
	protected GameEngine myGameEngine;
	
	public State(TopDownGameEngine parent,TopDownGameObject game) {
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
			myGameEngine.nextGameID = gameID;
			myGameObject.finish();
		}
	}

	public abstract void update(long arg0);
	
}
