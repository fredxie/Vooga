package state;

import java.awt.event.KeyEvent;

import util.JsonUtil;

import configuration.GameParameters;
import configuration.KeyAnnotation;
import configuration.SystemKeyPressedObserver;
import game.TopDownGameEngine;
import gameLevel.GameLevel;
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
//    	activateByPressedButton(KeyEvent.VK_ESCAPE, TopDownGameManager.GAMEBEGIN);
//    	activateByPressedButton(KeyEvent.VK_R, TopDownGameManager.GAMELEVELBEGIN);
		keyPressedObserver.pressKey(arg0);

	}

    @KeyAnnotation(action = GameParameters.SystemEscape)
	public void toMenu(long arg0) {
		TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMEBEGIN);
		myGameObject.finish();
	}
	
	@KeyAnnotation(action = GameParameters.SystemRestart)
	public void toNextLevel(long arg0) {
		TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMELEVELBEGIN);
		myGameObject.finish();
	}
	
}
