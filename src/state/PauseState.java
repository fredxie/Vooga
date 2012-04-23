package state;

/**
 * @author Jiawei Shi
 */


import util.JsonUtil;

import configuration.DemoSetting;
import configuration.GameParameters;
import configuration.KeyAnnotation;
import configuration.KeyPressedSubject;
import configuration.SystemKeyPressedObserver;

import game.TopDownGameEngine;
import gameLevel.GameLevel;
import gameObject.TopDownGameManager;
import gameObject.optionGameObject.OptionGameObject;
import gameObject.optionGameObject.Pause;

public class PauseState extends State {

	public PauseState(TopDownGameEngine parent, OptionGameObject game) {
		super(parent, game);
		game.setGameState(this);
		setStateID(1);

		keyPressedObserver = new SystemKeyPressedObserver(this);
		setKeyList(JsonUtil.createKeyList(this, "keyConfig.json",
				this.myGameObject));
	}

	@KeyAnnotation(action = GameParameters.SystemUp)
	public void optionArrowUp(long elapsedTime) {
		Pause game = (Pause) myGameObject;
		game.optionArrowUp(elapsedTime);
	}

	@KeyAnnotation(action = GameParameters.SystemDown)
	public void optionArrowDown(long elapsedTime) {
		Pause game = (Pause) myGameObject;
		game.optionArrowDown(elapsedTime);
	}

	@KeyAnnotation(action = GameParameters.SystemEnter)
	public void updateHelper(long arg0) {
		Pause game = (Pause) myGameObject;

		switch (game.getOption()) {
		case 0:
			// RESUME
			System.out.println("pausestate0");
			TopDownGameManager
					.setCurrentGameID(TopDownGameManager.getPreviousGameID());
			game.finish();
			break;

		case 1:
			// RESTART
			System.out.println("pausestate1");
			myGameEngine.initResources();
			TopDownGameManager
					.setCurrentGameID(TopDownGameManager.GAMELEVELBEGIN);
			// myGameEngine.nextGameID = 2;
			game.finish();
			break;

		case 2:
			// Setting
			System.out.println("pausestate2");
			DemoSetting setting = new DemoSetting();
			break;

		case 3:
			// menu
			System.out.println("pausestate3");
			myGameEngine.initResources();
			TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMEBEGIN);
			game.finish();
			break;
		}

	}

	public void gameFinish(GameLevel game, long arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(long arg0) {
		keyPressedObserver.pressKey(arg0);
//		KeyPressedSubject.getInstance().notifyObservers(arg0, this);
	}

}