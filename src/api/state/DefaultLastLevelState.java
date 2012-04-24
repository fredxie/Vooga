package api.state;

import java.awt.event.KeyEvent;

import demo.gameLevel.GameLevel2;
import demo.levelTransition.DemoLevelTransition;

import api.configuration.KeyAnnotation;
import api.configuration.KeyPressedSubject;
import api.configuration.SystemKeyPressedObserver;
import api.game.TopDownGameEngine;
import api.gameLevel.GameLevel;
import api.gameObject.TopDownGameManager;
import api.levelTransition.LevelTransition;
import api.util.JsonUtil;





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
		// KeyPressedSubject.getInstance().notifyObservers(arg0, this);

		GameLevel game = (GameLevel) myGameObject;
		gameFinish(game, arg0);
	}

	@KeyAnnotation(action = "SystemEscape")
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
