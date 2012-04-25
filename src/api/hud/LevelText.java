package api.hud;

import api.gameLevel.GameLevel;

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
