package demo;

import game.TopDownGameEngine;
import game.TopDownGameLoader;
import gameObject.GameLevel1;
import gameObject.GameLevel2;
import gameObject.Menu;
import gameObject.Pause;
import gameObject.TopDownGameObject;

import java.awt.Dimension;
import java.util.HashMap;

import state.Level1State;


public class DemoGameEngine extends TopDownGameEngine {

	{
		distribute = true;
	}

	//public static final int Menu = 0, GAME_Level1 = 1, GAME_Level2 = 2,PAUSE = 3;
	public static final int HEIGHT = 640;
	public static final int WIDTH = 480;

	private HashMap<Integer, TopDownGameObject> map;

	public DemoGameEngine() {
		map = new HashMap<Integer, TopDownGameObject>();
	}

	public void initResources() {
		
		
		TopDownGameObject t1 = new GameLevel1(this);
	    //Level1State state1 = new Level1State(this,t1);
		map.put(2, t1);
		
		TopDownGameObject t2 = new GameLevel2(this);
		//Level2State statr2 = new Level2State(this,t2);
		map.put(3, t2);
		
		TopDownGameObject pause = new Pause(this);
		//PauseState state3 = new PauseState(this,pause);
		map.put(1, pause);
		
		TopDownGameObject menu = new Menu(this);
		//MenuState state4 = new MenuState(this,menu);
		map.put(0, menu);
		
		nextGameID = 0;
	}

	public TopDownGameObject getGame(int GameID) {
		return map.get(nextGameID);
	}



	/****************************************************************************/
	/***************************** MAIN-CLASS ***********************************/
	/****************************************************************************/

	public static void main(String[] args) {

		TopDownGameLoader game = new TopDownGameLoader();
		game.setup(new DemoGameEngine(), new Dimension(WIDTH, HEIGHT), false);
		game.start();
	}
}