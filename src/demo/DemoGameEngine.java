package demo;

import game.TopDownGameEngine;
import game.TopDownGameLoader;
import gameObject.api_GameObject.TopDownGameManager;
import gameObject.demoGameObject.InterLevelScoreBoard;
import gameObject.demoGameObject.LostGameScoreBoard;
import gameObject.demoGameObject.Menu;
import gameObject.demoGameObject.Pause;
import gameObject.demoGameObject.WinGameScoreBoard;

import java.awt.Dimension;

import DemoGameLevel.GameLevel1;
import DemoGameLevel.GameLevel2;


public class DemoGameEngine extends TopDownGameEngine {

	public static final int HEIGHT = 640;
	public static final int WIDTH = 480;


	public DemoGameEngine() {
		
	}

	
	@Override
	public void addGameObjects() {
		TopDownGameManager.addNewGameObject(TopDownGameManager.GAMEBEGIN, new Menu(this));
		TopDownGameManager.addNewGameObject(TopDownGameManager.GAMEBEGIN+1, new Pause(this));
		TopDownGameManager.addNewGameObject(TopDownGameManager.GAMELEVELBEGIN, new GameLevel1(this));
		TopDownGameManager.addNewGameObject(TopDownGameManager.GAMELEVELBEGIN+1, new GameLevel2(this));	
		TopDownGameManager.addNewGameObject(TopDownGameManager.SCOREBOARD, new InterLevelScoreBoard(this));
		TopDownGameManager.addNewGameObject(TopDownGameManager.SCOREBOARD+1, new LostGameScoreBoard(this));
		TopDownGameManager.addNewGameObject(TopDownGameManager.SCOREBOARD+2, new WinGameScoreBoard(this));
	}

	@Override
	public void setInitialGameID() {
		TopDownGameManager.setInitialGameID(TopDownGameManager.GAMEBEGIN);	
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