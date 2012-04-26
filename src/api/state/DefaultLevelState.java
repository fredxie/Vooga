package api.state;

import api.configuration.KeyAnnotation;
import api.configuration.SystemKeyPressedObserver;
import api.game.TopDownGameEngine;
import api.gameLevel.GameLevel;
import api.gameObject.TopDownGameManager;
import api.util.JsonUtil;

/**
 * This class performs as the default state class for level game objects except
 * the final one. The developer can directly call this class if their game is
 * not too complex.
 * 
 * @author Jiawei Shi
 * 
 */
public class DefaultLevelState extends State {

	public DefaultLevelState(TopDownGameEngine parent, GameLevel game) {
		super(parent, game);
		myGameObject = game;
		game.setGameState(this);

		keyPressedObserver = new SystemKeyPressedObserver(this);
		setKeyList(JsonUtil.createKeyList(this, "json/keyConfig.json",
				this.myGameObject));
	}

	/**
	 * Transition between states
	 */
	public void update(long arg0) {
		keyPressedObserver.pressKey(arg0);
		GameLevel game = (GameLevel) myGameObject;
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
		myGameObject.finish();
	}

	/**
	 * Transitions from this this state if the current game state finishes. If
	 * the current game object completes, it will transit to the score board
	 * state. If the game is over, it will transit to the lost game state.
	 * 
	 * @param game
	 * @param arg0
	 */
	public void gameFinish(GameLevel game, long arg0) {

		if (game.levelComplete) {
			TopDownGameManager.setCurrentGameID(TopDownGameManager.SCOREBOARD);
			game.finish();
		}

		if (game.gameOver) {
			TopDownGameManager
					.setCurrentGameID(TopDownGameManager.SCOREBOARD + 1);
			game.finish();
		}

	}
	
	

}
