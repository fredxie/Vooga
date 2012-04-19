package gameObject;

/**
 * @author Jiawei Shi
 */

import game.TopDownGameEngine;

import java.util.HashMap;

import com.golden.gamedev.GameObject;

public class TopDownGameManager {

	public static int GAMEBEGIN = 0;
	public static int GAMELEVELBEGIN = 2;
	public static int SCOREBOARD = 50;
	private static HashMap<Integer, GameObject> map;
	private static int currentGameID;
	private static int initialGameID;
	private static int previousGameID;
	//private static TopDownGameEngine gameEngine;
	
	public static void initManager(TopDownGameEngine e){
		map = new HashMap<Integer,GameObject>();
		//gameEngine = e;
	}
	
	public static void setInitialGameID(int i){
		initialGameID = i;
		currentGameID = i;
		//gameEngine.nextGameID = i;
	}
	
	public static void addNewGameObject(int id, GameObject game){
		map.put(id, game);
	}
	
	public static GameObject getCurrentGameObject(){
		//return currentGameObject;
		return map.get(currentGameID);
	}
	
	public static GameObject getGameObject(int gameID){
		return map.get(gameID);
	}
	
	public static int getCurrentGameID(){
		return currentGameID;
	}
	
	public static void setCurrentGameID(int id){
		//gameEngine.nextGameID = id;
		previousGameID = currentGameID;
		currentGameID = id;
	}
	
	public static int getInitialGameID(){
		return initialGameID;
	}
	
	public static int getPreviousGameID(){
		return previousGameID;
	}
	
	
}
