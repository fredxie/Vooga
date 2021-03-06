package demo.state;

/**
 * @author Jiawei Shi
 */

import levelEditor.LevelEditor;
import levelEditor.Load;
import api.configuration.KeyAnnotation;
import api.configuration.KeyPressedSubject;
import api.configuration.SystemKeyPressedObserver;
import api.game.TopDownGameEngine;
import api.gameLevel.GameLevel;
import api.gameObject.OptionGameObject;
import api.gameObject.TopDownGameManager;
import api.state.State;
import api.util.JsonUtil;
import demo.configuration.DemoSetting;
import demo.gameObject.Menu;

public class MenuState extends State {
	TopDownGameEngine engine;

	public MenuState(TopDownGameEngine parent, OptionGameObject game) {
		super(parent, game);
		game.setGameState(this);
		setStateID(0);
		engine = parent;
		keyPressedObserver = new SystemKeyPressedObserver(this);
		setKeyList(JsonUtil.createKeyList(this, "json/keyConfig.json",
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

	@SuppressWarnings("unused")
	@KeyAnnotation(action = "SystemEnter")
	public void optionEnter(long arg0) {
		Menu game = (Menu) myGameObject;

		switch (game.getOption()) {
		case 0:
			// start easy game
			TopDownGameManager
					.setCurrentGameID(TopDownGameManager.GAMELEVELBEGIN);

			game.finish();
			break;

		case 1:
			// level editor
			LevelEditor l = new LevelEditor();
			break;

		case 2:
			// load and start game
			Load load = new Load();
			game.finish();
			break;

		case 3:
			TopDownGameManager
					.setCurrentGameID(TopDownGameManager.GAMELEVELBEGIN + 2);
			game.finish();
			break;

		case 4:
			DemoSetting setting = new DemoSetting();
			break;

		case 5:
			engine.finish();
			break;
		}

	}

	public void gameFinish(GameLevel game, long arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(long arg0) {
		KeyPressedSubject.getInstance().notifyObservers(arg0, this);
	}

}