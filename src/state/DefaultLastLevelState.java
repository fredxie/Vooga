package state;

import java.awt.event.KeyEvent;

import levelTransition.LevelTransition;

import DemoGameLevel.GameLevel2;
import DemoLevelTransition.DemoLevelTransition;

import util.JsonUtil;
import configuration.GameParameters;
import configuration.KeyAnnotation;
import configuration.SystemKeyPressedObserver;

import game.TopDownGameEngine;
import gameLevel.GameLevel;
import gameObject.TopDownGameManager;

public class DefaultLastLevelState extends State {

	public DefaultLastLevelState(TopDownGameEngine parent, GameLevel game) {
		super(parent, game);
		game.setGameState(this);
		keyPressedObserver = new SystemKeyPressedObserver(this);
		setKeyList(JsonUtil.createKeyList(this, "keyConfig.json",
				this.myGameObject));
	}

	@Override
	public void update(long arg0) {
		keyPressedObserver.pressKey(arg0);
		// activateByPressedButton(KeyEvent.VK_ESCAPE,
		// TopDownGameManager.GAMEBEGIN+1);
		GameLevel game = (GameLevel) myGameObject;
		gameFinish(game, arg0);
	}

	@KeyAnnotation(action = GameParameters.SystemEscape)
	public void updateHelper(long arg0) {
		TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMEBEGIN + 1);
		myGameObject.finish();
	}

	public void gameFinish(GameLevel game, long arg0) {
		if (game.levelComplete) {
			TopDownGameManager
					.setCurrentGameID(TopDownGameManager.SCOREBOARD + 2);
			game.finish();
		}

	}

}
