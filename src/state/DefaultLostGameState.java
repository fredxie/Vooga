package state;

import java.awt.event.KeyEvent;
import game.TopDownGameEngine;
import gameObject.GameLevel;
import gameObject.TopDownGameManager;
import gameObject.scoreBoardGameObject.ScoreBoardGameObject;

public class DefaultLostGameState extends State{

	public DefaultLostGameState(TopDownGameEngine parent, ScoreBoardGameObject game) {
		super(parent, game);
		game.setGameState(this);
	}

    public void update(long arg0) {
    	activateByPressedButton(KeyEvent.VK_ESCAPE, TopDownGameManager.GAMEBEGIN);
    	activateByPressedButton(KeyEvent.VK_R, TopDownGameManager.GAMELEVELBEGIN);
	}

	@Override
	public void gameFinish(GameLevel game, long arg0) {
		// TODO Auto-generated method stub
		
	}

}
