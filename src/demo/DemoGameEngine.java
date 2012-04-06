package demo;

import game.TopDownGameEngine;
import game.TopDownGameLoader;
import game.TopDownGameObject;

import java.awt.*;
import java.util.HashMap;

import demoState.*;

public class DemoGameEngine extends TopDownGameEngine {

	{
		distribute = true;
	}

	public static final int Menu = 0, GAME_Level1 = 1, GAME_Level2 = 2,PAUSE = 3;
	public static final int HEIGHT = 640;
	public static final int WIDTH = 480;

	private HashMap<Integer, TopDownGameObject> map;

	public DemoGameEngine() {
		map = new HashMap<Integer, TopDownGameObject>();
	}

	public void initResources() {

		map.put(GAME_Level1, new GameLevel1State(this));
		map.put(GAME_Level2, new GameLevel2State(this));
		map.put(PAUSE, new PauseState(this));
		map.put(Menu, new MenuState(this));

		nextGameID = Menu;
	}

	public TopDownGameObject getGame(int GameID) {
		return map.get(nextGameID);
	}

	public HashMap<Integer, TopDownGameObject> getMap() {
		return map;
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
