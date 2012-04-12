package state;

/**
 * @author Jiawei Shi
 */

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import configuration.DemoSetting;
import configuration.Setting1;

import levelEditor.LevelEditor;
import menu.GameSL;

import game.Configuration;
import game.TopDownGameEngine;
import gameObject.GameLevel;
import gameObject.Menu;
import gameObject.TopDownGameObject;

import element.Element;

public class MenuState extends State {

	public MenuState(TopDownGameEngine parent, TopDownGameObject game) {
		super(parent, game);
		myGameObject.setGameState(this);
		setStateID(0);
	}

	@Override
	public void update(long arg0) {
		if(myGameObject.bsInput.getKeyPressed() == KeyEvent.VK_ENTER ||
				myGameObject.bsInput.getKeyPressed() == KeyEvent.VK_SPACE){
			Menu game = (Menu) myGameObject;
			System.out.println(game.getOption());
			switch(game.getOption()){
			case 0:
				// start easy game
				myGameEngine.nextGameID = 2;
				game.finish();
				break;
			
			case 1:
				// end
				game.finish();
				//finish();
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

	@Override
	public void gameFinish(GameLevel game, long arg0) {
		// TODO Auto-generated method stub
		
	}



}
