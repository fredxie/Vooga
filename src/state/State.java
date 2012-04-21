
package state;


/**
 * @author Jiawei Shi
 */


import game.TopDownGameEngine;
import gameLevel.GameLevel;
import gameObject.TopDownGameManager;

import collisionSystem.EnemyBulletCollision;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;


public abstract class State{
	private static int stateID;
	protected GameObject myGameObject;
	protected TopDownGameEngine myGameEngine;
	
	public State(TopDownGameEngine parent,GameObject game) {
		myGameEngine = parent;
		myGameObject = game;
	}
	
	public void setStateID(int name){
		stateID = name;
	}

	public static int getStateID(){
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
	
	public void initGameRecord(){
		EnemyBulletCollision.destroyed = 0;
	}


	//public abstract void gameFinish(GameLevel game, long arg0);
}
