package state;

import java.awt.event.KeyEvent;

import game.TopDownGameEngine;
import gameObject.GameLevel;
import gameObject.TopDownGameManager;
import gameObject.scoreBoardGameObject.InterLevelScoreBoard;

public class DefaultInterLevelState extends State{

	public DefaultInterLevelState(TopDownGameEngine parent, InterLevelScoreBoard game) {
		super(parent, game);
		game.setGameState(this);
	}

	@Override
	public void update(long arg0) {
		activateByPressedButton(KeyEvent.VK_SPACE, TopDownGameManager.getPreviousGameID()+1);
		activateByPressedButton(KeyEvent.VK_ESCAPE, TopDownGameManager.GAMEBEGIN);
		
	}



}
