package state;

import java.awt.event.KeyEvent;
import game.TopDownGameEngine;
import gameLevel.GameLevel;
import gameObject.TopDownGameManager;
import gameObject.scoreBoardGameObject.ScoreBoardGameObject;

public class DefaultFinishGameState extends State{

	public DefaultFinishGameState(TopDownGameEngine parent, ScoreBoardGameObject game) {
		super(parent, game);
		game.setGameState(this);
	}

    public void update(long arg0) {
    	activateByPressedButton(KeyEvent.VK_ESCAPE, TopDownGameManager.GAMEBEGIN);
    	activateByPressedButton(KeyEvent.VK_R, TopDownGameManager.GAMELEVELBEGIN);
	}

	
}
