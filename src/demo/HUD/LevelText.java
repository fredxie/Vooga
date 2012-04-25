package demo.HUD;

import api.gameLevel.GameLevel;
import api.hud.DisplayText;

public class LevelText extends DisplayText {
	private GameLevel myLevel;
	
	public LevelText(GameLevel level) {
		super();
		myLevel = level;
	}
	
	@Override
	public String getString() {
		return " " + myLevel.level;
	}
}
