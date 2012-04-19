package state;

/**
 * @author Jiawei Shi
 */

import java.awt.event.KeyEvent;

import configuration.DemoSetting;

import game.TopDownGameEngine;
import gameObject.GameLevel;
import gameObject.TopDownGameManager;
import gameObject.TopDownGameObject;
import gameObject.optionGameObject.OptionGameObject;
import gameObject.optionGameObject.Pause;

public class PauseState extends State{

	public PauseState(TopDownGameEngine parent,OptionGameObject game) {
		super(parent,game);
		game.setGameState(this);
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
				//myGameEngine.nextGameID = 2;
				TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMELEVELBEGIN);
				game.finish();
				break;

			case 1:
				// RESTART
				myGameEngine.initResources();
				TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMELEVELBEGIN);
				//myGameEngine.nextGameID = 2;
				game.finish();
				break;

			case 2:
				// Setting
				DemoSetting setting = new DemoSetting();
				break;

			case 3:
				// menu
				myGameEngine.initResources();
				//myGameEngine.nextGameID = 0;
				TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMEBEGIN);
				game.finish();
				break;	
			}

	}

}
}