package api.state;

import java.awt.event.KeyEvent;

import demo.gameObject.InterLevelScoreBoard;

import api.configuration.KeyAnnotation;
import api.configuration.KeyPressedSubject;
import api.configuration.SystemKeyPressedObserver;
import api.game.TopDownGameEngine;
import api.gameLevel.GameLevel;
import api.gameObject.TopDownGameManager;
import api.util.JsonUtil;




public class DefaultInterLevelState extends State {

	public DefaultInterLevelState(TopDownGameEngine parent,
			InterLevelScoreBoard game) {
		super(parent, game);
		game.setGameState(this);
		keyPressedObserver = new SystemKeyPressedObserver(this);
		setKeyList(JsonUtil.createKeyList(this, "keyConfig.json",
				this.myGameObject));
	}

	@Override
	public void update(long arg0) {
		keyPressedObserver.pressKey(arg0);
		// KeyPressedSubject.getInstance().notifyObservers(arg0, this);

	}

	@KeyAnnotation(action = "SystemEscape")
	public void toMenu(long arg0) {
		System.out.println("interstate0");
		TopDownGameManager.setCurrentGameID(TopDownGameManager.GAMEBEGIN);
		myGameObject.finish();
	}

	@KeyAnnotation(action = "SystemSpace")
	public void toNextLevel(long arg0) {
		System.out.println("interstate1");
		TopDownGameManager.setCurrentGameID(TopDownGameManager
				.getPreviousGameID() + 1);
		myGameObject.finish();
	}

}
