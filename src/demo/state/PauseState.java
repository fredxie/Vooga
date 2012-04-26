package demo.state;

/**
 * @author Jiawei Shi
 */

import api.configuration.KeyAnnotation;
import api.configuration.SystemKeyPressedObserver;
import api.game.TopDownGameEngine;
import api.gameLevel.GameLevel;
import api.gameObject.OptionGameObject;
import api.gameObject.TopDownGameManager;
import api.state.State;
import api.util.JsonUtil;
import demo.configuration.DemoSetting;
import demo.gameObject.Pause;


public class PauseState extends State {

	public PauseState(TopDownGameEngine parent, OptionGameObject game) {
		super(parent, game);
		game.setGameState(this);
		setStateID(1);

		setKeyPressedObserver(new SystemKeyPressedObserver(this));
		setKeyList(JsonUtil.createKeyList(this, "json/keyConfig.json",
				getGameObject()));
	}

	@KeyAnnotation(action = "SystemUp")
	public void optionArrowUp(long elapsedTime) {
		Pause game = (Pause) getGameObject();
		game.optionArrowUp(elapsedTime);
	}

	@KeyAnnotation(action = "SystemDown")
	public void optionArrowDown(long elapsedTime) {
		Pause game = (Pause) getGameObject();
		game.optionArrowDown(elapsedTime);
	}

	@SuppressWarnings("unused")
	@KeyAnnotation(action = "SystemEnter")
	public void optionEnter(long arg0) {
		Pause game = (Pause) getGameObject();

		switch (game.getOption()) {
		case 0:
			// RESUME
			System.out.println("pausestate0");
			TopDownGameManager.setCurrentGameID(TopDownGameManager
					.getPreviousGameID());
			game.finish();
			break;

		case 1:
			// RESTART
			System.out.println("pausestate1");
			getGameEngine().initResources();
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
			getGameEngine().initResources();
			TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMEBEGIN);
			game.finish();
			break;
		}

	}

	public void gameFinish(GameLevel game, long arg0) {

	}

	@Override
	public void update(long arg0) {
		getKeyPressedObserver().pressKey(arg0);
	}

}