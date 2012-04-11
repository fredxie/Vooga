package state;

/**
 * @author Jiawei Shi
 */

import game.TopDownGameEngine;
import gameObject.GameLevel;
import gameObject.GameLevel2;
import gameObject.TopDownGameObject;

import java.awt.event.KeyEvent;

public class Level2State extends State {

	public Level2State(TopDownGameEngine parent, TopDownGameObject game) {
		super(parent, game);
		myGameObject.setGameState(this);
		setStateID(3);
	}

	@Override
	public void update(long arg0) {

		activateByPressedButton(KeyEvent.VK_ESCAPE, 1);

		GameLevel2 game = (GameLevel2) myGameObject;
		gameFinish(game, arg0);
	}

	@Override
	public void gameFinish(GameLevel game, long arg0) {
		if (game.levelComplete()) {
			if (GameLevel2.timer.action(arg0)) {
				game.levelComplete = false;
				myGameEngine.nextGameID = 0;
				game.finish();
			}
		}

	}

}
