package state.api;

import game.TopDownGameEngine;
import gameLevel.GameLevel;
import gameObject.api_GameObject.TopDownGameManager;
import util.JsonUtil;
import configuration.api.GameParameters;
import configuration.api.KeyAnnotation;
import configuration.api.SystemKeyPressedObserver;


// hello
public class DefaultLevelState extends State {

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
		keyPressedObserver.pressKey(arg0);
//		KeyPressedSubject.getInstance().notifyObservers(arg0, this);

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
			TopDownGameManager.setCurrentGameID(TopDownGameManager.SCOREBOARD);
			game.finish();
		}

		if (game.gameOver) {
			TopDownGameManager
					.setCurrentGameID(TopDownGameManager.SCOREBOARD + 1);
			game.finish();
		}

	}

}
