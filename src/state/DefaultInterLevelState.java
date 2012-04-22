package state;

import java.awt.event.KeyEvent;

import util.JsonUtil;

import configuration.GameParameters;
import configuration.KeyAnnotation;
import configuration.SystemKeyPressedObserver;

import game.TopDownGameEngine;
import gameLevel.GameLevel;
import gameObject.TopDownGameManager;
import gameObject.scoreBoardGameObject.InterLevelScoreBoard;

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
//		activateByPressedButton(KeyEvent.VK_SPACE, TopDownGameManager.getPreviousGameID()+1);
//		activateByPressedButton(KeyEvent.VK_ESCAPE, TopDownGameManager.GAMEBEGIN);
		keyPressedObserver.pressKey(arg0);
	}

	@KeyAnnotation(action = GameParameters.SystemEscape)
	public void toMenu(long arg0) {
		TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMEBEGIN);
		myGameObject.finish();
	}
	
	@KeyAnnotation(action = GameParameters.SystemSpace)
	public void toNextLevel(long arg0) {
		TopDownGameManager.setCurrentGameID(TopDownGameManager.getPreviousGameID()+1);
		myGameObject.finish();
	}

	

}
