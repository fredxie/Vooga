package state.demo;

/**
 * @author Jiawei Shi
 */

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import state.api.State;
import util.JsonUtil;

import configuration.api.KeyAnnotation;
import configuration.api.KeyPressedSubject;
import configuration.api.SystemKeyPressedObserver;
import configuration.demo.DemoSetting;

import levelEditor.LevelEditor;
import levelEditor.Load;
import menu.GameSL;

import game.Configuration;
import game.TopDownGameEngine;
import gameLevel.GameLevel;
import gameObject.api_GameObject.OptionGameObject;
import gameObject.api_GameObject.TopDownGameManager;
import gameObject.demoGameObject.Menu;

import element.Element;

public class MenuState extends State {
	TopDownGameEngine engine;

	public MenuState(TopDownGameEngine parent, OptionGameObject game) {
		super(parent, game);
		game.setGameState(this);
		setStateID(0);
		engine = parent;
		keyPressedObserver = new SystemKeyPressedObserver(this);
		setKeyList(JsonUtil.createKeyList(this, "keyConfig.json",
				this.myGameObject));

	}

	@KeyAnnotation(action = "SystemUp")
	public void optionArrowUp(long elapsedTime) {
		Menu game = (Menu) myGameObject;
		game.optionArrowUp(elapsedTime);
	}

	@KeyAnnotation(action = "SystemDown")
	public void optionArrowDown(long elapsedTime) {
		Menu game = (Menu) myGameObject;
		game.optionArrowDown(elapsedTime);
	}

	@KeyAnnotation(action = "SystemEnter")
	public void updateHelper(long arg0) {
		Menu game = (Menu) myGameObject;

		switch (game.getOption()) {
		case 0:
			// start easy game
			TopDownGameManager
					.setCurrentGameID(TopDownGameManager.GAMELEVELBEGIN);
			System.out.println("menustate0");
			game.finish();
			break;

		case 1:
			// end
			// game.finish();
			engine.finish();
			break;

		case 2:
			// level editor
			LevelEditor l = new LevelEditor();
			break;

		case 3:
			// load and start game
			Load load = new Load();
			break;

		case 4:
			DemoSetting setting = new DemoSetting();
			break;
		}
	}

	public void gameFinish(GameLevel game, long arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(long arg0) {
		KeyPressedSubject.getInstance().notifyObservers(arg0, this);
		// keyPressedObserver.pressKey(arg0);

	}

}