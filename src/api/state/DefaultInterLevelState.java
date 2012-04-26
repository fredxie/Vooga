package api.state;

import api.configuration.KeyAnnotation;
import api.configuration.SystemKeyPressedObserver;
import api.game.TopDownGameEngine;
import api.gameObject.TopDownGameManager;
import api.util.JsonUtil;
import demo.gameObject.InterLevelScoreBoard;

/**
 * This class performs as the default state class for the state between
 * different level of states. The developer can directly call this class if
 * their game is not too complex.
 * 
 * @author Jiawei Shi
 * 
 */

public class DefaultInterLevelState extends State {

	public DefaultInterLevelState(TopDownGameEngine parent,
			InterLevelScoreBoard game) {
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
		getGameObject().finish();
	}

	/**
	 * Transition between this state to the next game state. After the key is
	 * pressed, the game will restart
	 * 
	 * @param arg0
	 */
	@KeyAnnotation(action = "SystemSpace")
	public void restartPressed(long arg0) {
		TopDownGameManager.setCurrentGameID(TopDownGameManager
				.getPreviousGameID() + 1);
		getGameObject().finish();
	}

}
