package api.state;

import api.configuration.KeyAnnotation;
import api.configuration.SystemKeyPressedObserver;
import api.game.TopDownGameEngine;
import api.gameLevel.GameLevel;
import api.gameObject.TopDownGameManager;
import api.util.JsonUtil;

/**
 * This class performs as the default state class for the final game object. The
 * developer can directly call this class if their game is not too complex.
 * 
 * @author Jiawei Shi
 * 
 */
public class DefaultLastLevelState extends State {

	public DefaultLastLevelState(TopDownGameEngine parent, GameLevel game) {
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
		GameLevel game = (GameLevel) getGameObject();
		gameFinish(game, arg0);
	}

	/**
	 * Transition from this state to the pause state. The user can personalize
	 * the key configuration
	 * 
	 * @param arg0
	 */
	@KeyAnnotation(action = "SystemEscape")
	public void escapePressed(long arg0) {
		TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMEBEGIN + 1);
		getGameObject().finish();
	}

	/**
	 * Transitions from this this state if the current game state finishes. If
	 * the current game object completes, it will transit to the score board
	 * state.
	 * 
	 * @param game
	 * @param arg0
	 */
	public void gameFinish(GameLevel game, long arg0) {
		if (game.levelComplete) {
			TopDownGameManager
					.setCurrentGameID(TopDownGameManager.SCOREBOARD + 2);
			game.finish();
		}

	}

}
