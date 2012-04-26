package api.state;

import api.configuration.KeyAnnotation;
import api.configuration.SystemKeyPressedObserver;
import api.game.TopDownGameEngine;
import api.gameObject.ScoreBoardGameObject;
import api.gameObject.TopDownGameManager;
import api.util.JsonUtil;

/**
 * This class performs as the default state for the state that the game
 * finishes. Developer can directly use this class if their game is not too
 * complex
 * 
 * @author Jiawei Shi
 * 
 */

public class DefaultFinishGameState extends State {

	public DefaultFinishGameState(TopDownGameEngine parent,
			ScoreBoardGameObject game) {
		super(parent, game);
		game.setGameState(this);
		setKeyPressedObserver(new SystemKeyPressedObserver(this));
		setKeyList(JsonUtil.createKeyList(this, "json/keyConfig.json",
				getGameObject()));
	}

	/**
	 * Transition between states
	 */
	public void update(long arg0) {
		getKeyPressedObserver().pressKey(arg0);
	}

	/**
	 * Transition from this state to the menu state. The user can personalize
	 * the key configuration
	 * 
	 * @param arg0
	 */
	@KeyAnnotation(action = "SystemEscape")
	public void escapePressed(long arg0) {
		TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMEBEGIN);
		getGameEngine().initResources();
		getGameObject().finish();
	}

	/**
	 * Transition between this state to the initial game state. After the key is
	 * pressed, the game will restart
	 * 
	 * @param arg0
	 */
	@KeyAnnotation(action = "SystemRestart")
	public void restartPressed(long arg0) {
		TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMELEVELBEGIN);
		getGameObject().finish();
	}

}
