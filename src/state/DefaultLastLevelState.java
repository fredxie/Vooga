package state;

import java.awt.event.KeyEvent;

import game.TopDownGameEngine;
import gameObject.GameLevel;
import gameObject.GameLevel2;
import gameObject.TopDownGameManager;

public class DefaultLastLevelState extends State{

	public DefaultLastLevelState(TopDownGameEngine parent, GameLevel game) {
		super(parent, game);
		game.setGameState(this);
	}

	@Override
	public void update(long arg0) {
		activateByPressedButton(KeyEvent.VK_ESCAPE, TopDownGameManager.GAMEBEGIN+1);
		GameLevel game = (GameLevel) myGameObject;
		gameFinish(game, arg0);
	}

	@Override
	public void gameFinish(GameLevel game, long arg0) {
		if (game.levelComplete()) {
			if (GameLevel2.timer.action(arg0)) {
				game.levelComplete = false;
				//myGameEngine.nextGameID = TopDownGameManager.GAMEBEGIN;
				TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMEBEGIN);
				game.finish();
			}
		}
		
	}

}
