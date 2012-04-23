package state;

import util.JsonUtil;

import configuration.GameParameters;
import configuration.KeyAnnotation;
import configuration.KeyPressedSubject;
import configuration.SystemKeyPressedObserver;
import game.TopDownGameEngine;
import gameObject.TopDownGameManager;
import gameObject.scoreBoardGameObject.ScoreBoardGameObject;

public class DefaultFinishGameState extends State{

	public DefaultFinishGameState(TopDownGameEngine parent, ScoreBoardGameObject game) {
		super(parent, game);
		game.setGameState(this);
		keyPressedObserver = new SystemKeyPressedObserver(this);
		setKeyList(JsonUtil.createKeyList(this, "keyConfig.json",
				this.myGameObject));
	}

    public void update(long arg0) {
		keyPressedObserver.pressKey(arg0);
//		KeyPressedSubject.getInstance().notifyObservers(arg0, this);

	}

    @KeyAnnotation(action = GameParameters.SystemEscape)
	public void toMenu(long arg0) {
		TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMEBEGIN);
		myGameEngine.initResources();
		myGameObject.finish();
	}
	
	@KeyAnnotation(action = GameParameters.SystemRestart)
	public void toNextLevel(long arg0) {
		TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMELEVELBEGIN);
		myGameObject.finish();
	}
	
}
