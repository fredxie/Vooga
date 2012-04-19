package state;

import java.awt.event.KeyEvent;

import game.TopDownGameEngine;
import gameObject.GameLevel;
import gameObject.TopDownGameManager;

public class DefaultLevelState extends State{

	public DefaultLevelState(TopDownGameEngine parent, GameLevel game) {
		super(parent, game);
		myGameObject = game;
		game.setGameState(this);
	}

	@Override
	public void update(long arg0) {
		activateByPressedButton(KeyEvent.VK_ESCAPE, 1);
		
		GameLevel game = (GameLevel) myGameObject;
		gameFinish(game, arg0);
	}


	public void gameFinish(GameLevel game, long arg0) {
		/*if (game.levelComplete()) {
			if (GameLevel1.timer.action(arg0)) {
				game.levelComplete = false;
				//myGameEngine.nextGameID = TopDownGameManager.getCurrentGameID() + 1;
				TopDownGameManager.setCurrentGameID(TopDownGameManager.getCurrentGameID() + 1);
				game.setLevel(TopDownGameManager.getCurrentGameID() + 1);
				game.finish();
			}
		}*/
		if(game.levelComplete()){
			TopDownGameManager.setCurrentGameID(TopDownGameManager.SCOREBOARD);
			game.finish();
		}
		if(game.isGameOver()){
			TopDownGameManager.setCurrentGameID(TopDownGameManager.SCOREBOARD+1);
			game.finish();
		}
		
	}

}
