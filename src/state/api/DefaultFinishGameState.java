package state.api;

import util.JsonUtil;

import configuration.api.KeyAnnotation;
import configuration.api.KeyPressedSubject;
import configuration.api.SystemKeyPressedObserver;
import game.TopDownGameEngine;
import gameObject.api_GameObject.ScoreBoardGameObject;
import gameObject.api_GameObject.TopDownGameManager;

public class DefaultFinishGameState extends State {

	public DefaultFinishGameState(TopDownGameEngine parent,
			ScoreBoardGameObject game) {
		super(parent, game);
		game.setGameState(this);
		keyPressedObserver = new SystemKeyPressedObserver(this);
		setKeyList(JsonUtil.createKeyList(this, "keyConfig.json",
				this.myGameObject));
	}

	public void update(long arg0) {
		keyPressedObserver.pressKey(arg0);
		// KeyPressedSubject.getInstance().notifyObservers(arg0, this);

	}

	@KeyAnnotation(action = "SystemEscape")
	public void toMenu(long arg0) {
		TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMEBEGIN);
		myGameEngine.initResources();
		myGameObject.finish();
	}

	@KeyAnnotation(action = "SystemRestart")
	public void toNextLevel(long arg0) {
		TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMELEVELBEGIN);
		myGameObject.finish();
	}

}
