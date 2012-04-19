package state;

import java.awt.event.KeyEvent;

import game.TopDownGameEngine;
import gameObject.GameLevel;
import gameObject.TopDownGameManager;
import gameObject.scoreBoardGameObject.ScoreBoardGameObject;

public class DefaultInnerLevelState extends State{

	public DefaultInnerLevelState(TopDownGameEngine parent, ScoreBoardGameObject game) {
		super(parent, game);
		game.setGameState(this);
	}

	@Override
	public void update(long arg0) {
		activateByPressedButton(KeyEvent.VK_SPACE, TopDownGameManager.getCurrentGameID()+1);
		activateByPressedButton(KeyEvent.VK_ESCAPE, TopDownGameManager.GAMEBEGIN);
	}

	@Override
	public void gameFinish(GameLevel game, long arg0) {
		// TODO Auto-generated method stub
		
	}

}
