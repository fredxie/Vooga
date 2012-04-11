package state;

/**
 * @author Jiawei Shi
 */

import game.TopDownGameEngine;
import gameObject.GameLevel1;
import gameObject.TopDownGameObject;

import java.awt.event.KeyEvent;

public class Level1State extends State{

	public Level1State(TopDownGameEngine parent,TopDownGameObject game) {
		super(parent,game);
		myGameObject.setGameState(this);
		setStateID(2);
	}

	@Override
	public void update(long arg0) {
		
		activateByPressedButton(KeyEvent.VK_ESCAPE,1);
		
		GameLevel1 game = (GameLevel1) myGameObject;
		if(game.levelComplete())
		{
			if(GameLevel1.timer.action(arg0)){
				game.levelComplete = false;
				myGameEngine.nextGameID = getStateID()+1;
				game.setLevel(game.getLevel() + 1);
				game.finish();
			}
		}
		
	}

}
