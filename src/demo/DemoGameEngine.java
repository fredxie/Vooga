package demo;


import game.TopDownGameEngine;
import game.TopDownGameLoader;
import game.TopDownGameObject;

import java.awt.*;


public class DemoGameEngine extends TopDownGameEngine {

	{
		distribute = true;
	}

	public static final int MENU = 0, EASY_GAME = 1, HARD_GAME = 2;
	public static final int HEIGHT = 640;
	public static final int WIDTH = 480;

	public void initResources() {
		nextGameID = MENU;
	}

	public TopDownGameObject getGame(int GameID) {
		switch (GameID) {
		case MENU:
			return new DemoMenu(this);

		case EASY_GAME: {
//			Configuration.setter(EASY_GAME);
			return new DemoGame(this);
		}
		
//		case HARD_GAME: {
//			Configuration.setter(HARD_GAME);
//			return new PlaneFighterGame(this);
//		}
		
		} 
		return null;
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

