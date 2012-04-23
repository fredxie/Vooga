package state.api_State;

import java.awt.event.KeyEvent;

import util.JsonUtil;

import configuration.GameParameters;
import configuration.KeyAnnotation;
import configuration.KeyPressedSubject;
import configuration.SystemKeyPressedObserver;

import game.TopDownGameEngine;
import gameLevel.GameLevel;
import gameObject.api_GameObject.TopDownGameManager;
import gameObject.demoGameObject.InterLevelScoreBoard;

public class DefaultInterLevelState extends State{

	public DefaultInterLevelState(TopDownGameEngine parent, InterLevelScoreBoard game) {
		super(parent, game);
		game.setGameState(this);
		keyPressedObserver = new SystemKeyPressedObserver(this);
		setKeyList(JsonUtil.createKeyList(this, "keyConfig.json",
				this.myGameObject));
	}

	@Override
	public void update(long arg0) {
		keyPressedObserver.pressKey(arg0);
//		KeyPressedSubject.getInstance().notifyObservers(arg0, this);

	}

	@KeyAnnotation(action = GameParameters.SystemEscape)
	public void toMenu(long arg0) {
		System.out.println("interstate0");
		TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMEBEGIN);
		myGameObject.finish();
	}
	
	@KeyAnnotation(action = GameParameters.SystemSpace)
	public void toNextLevel(long arg0) {
		System.out.println("interstate1");
		TopDownGameManager.setCurrentGameID(TopDownGameManager.getPreviousGameID()+1);
		myGameObject.finish();
	}

	

}
