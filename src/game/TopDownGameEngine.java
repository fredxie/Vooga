package game;

/**
 * @author Jiawei Shi
 */

import gameObject.TopDownGameManager;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;

public abstract class TopDownGameEngine extends GameEngine {
	{
		distribute = true;
	}

	public static int HEIGHT;
	public static int WIDTH;
	
	public TopDownGameEngine(){
		TopDownGameManager.initManager(this);
	}

	
	public void initResources(){
		super.initResources();
		addGameObjects();
		setInitialGameID();
	}
	
	public void update(long elapsedTime){
		nextGameID = TopDownGameManager.getCurrentGameID();
	}
	
	public GameObject getGame(int gameID){
		//nextGameID = TopDownGameManager.getCurrentGameID();
		return TopDownGameManager.getGameObject(nextGameID);
	}
	
	public abstract void addGameObjects();
	
	public abstract void setInitialGameID();
	
	
}
