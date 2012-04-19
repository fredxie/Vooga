package state;

/**
 * @author Jiawei Shi
 */

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import configuration.DemoSetting;

import levelEditor.LevelEditor;
import menu.GameSL;

import game.Configuration;
import game.TopDownGameEngine;
import gameObject.GameLevel;
import gameObject.TopDownGameManager;
import gameObject.optionGameObject.Menu;
import gameObject.optionGameObject.OptionGameObject;

import element.Element;

public class MenuState extends State {
	TopDownGameEngine engine;

	public MenuState(TopDownGameEngine parent, OptionGameObject game) {
		super(parent, game);
		game.setGameState(this);
		setStateID(0);
		engine = parent;
	}

	@Override
	public void update(long arg0) {
		if(myGameObject.bsInput.getKeyPressed() == KeyEvent.VK_ENTER ||
				myGameObject.bsInput.getKeyPressed() == KeyEvent.VK_SPACE){
			Menu game = (Menu) myGameObject;
			
			switch(game.getOption()){
			case 0:
				// start easy game
				TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMELEVELBEGIN);
				//myGameEngine.nextGameID = 2;
				game.finish();
				break;

			case 1:
				// end
				//game.finish();
				engine.finish();
				break;

			case 2:
				// level editor
				LevelEditor l = new LevelEditor();
				break;

			case 3:
				// load and start game
				GameSL sl = new GameSL();
				try {
					ArrayList<Element> list = sl.loadElement("1.jason");
					HashMap<Integer, String> map = sl.loadMap("1.jason");
					String path = map.get(0);
					Configuration.BACKGROUND_PATH = path;
				} catch (IOException e) {

				}
				break;

			case 4:
				DemoSetting setting = new DemoSetting();
				break;
			}
		}

	}


}