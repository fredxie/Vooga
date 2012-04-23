package state;

import java.awt.event.KeyEvent;

import util.JsonUtil;
import configuration.GameParameters;
import configuration.KeyAnnotation;
import configuration.SystemKeyPressedObserver;

import collisionSystem.EnemyBulletCollision;

import game.TopDownGameEngine;
import gameLevel.GameLevel;
import gameObject.TopDownGameManager;

public class DefaultLevelState extends State{

	public DefaultLevelState(TopDownGameEngine parent, GameLevel game) {
		super(parent, game);
		myGameObject = game;
		game.setGameState(this);
		
		keyPressedObserver = new SystemKeyPressedObserver(this);
		setKeyList(JsonUtil.createKeyList(this, "keyConfig.json",
				this.myGameObject));
	}

	@Override
	public void update(long arg0) {
//		activateByPressedButton(KeyEvent.VK_ESCAPE, 1);
		keyPressedObserver.pressKey(arg0);
		GameLevel game = (GameLevel) myGameObject;
		gameFinish(game, arg0);
	}
	
	@KeyAnnotation(action = GameParameters.SystemEscape)
	public void updateHelper(long arg0) {
		TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMEBEGIN+1);
		myGameObject.finish();
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
