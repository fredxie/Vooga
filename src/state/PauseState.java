package state;

/**
 * @author Jiawei Shi
 */

import java.awt.event.KeyEvent;

import game.TopDownGameEngine;
import gameObject.Pause;
import gameObject.TopDownGameObject;

public class PauseState extends State{

	public PauseState(TopDownGameEngine parent,TopDownGameObject game) {
		super(parent,game);
		myGameObject.setGameState(this);
		setStateID(1);
	}

	@Override
	public void update(long arg0) {
		if(myGameObject.bsInput.getKeyPressed() == KeyEvent.VK_ENTER ||
				myGameObject.bsInput.getKeyPressed() == KeyEvent.VK_SPACE){
			Pause game = (Pause) myGameObject;
			
			switch(game.getOption()){
			case 0:
				// RESUME
				myGameEngine.nextGameID = 2;
				game.finish();
				break;
			
			case 1:
				// RESTART
				myGameEngine.initResources();
				myGameEngine.nextGameID = 2;
				game.finish();
				break;
				
			case 2:
				// Setting
				System.out.println("setting");
				break;
				
			case 3:
				// menu
				myGameEngine.initResources();
				myGameEngine.nextGameID = 0;
				game.finish();
				break;	
			}
		
	}

}
}
