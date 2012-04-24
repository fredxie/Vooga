package hud;

import gameLevel.GameLevel;

public class LevelInfo implements HUDInfo {
	public LevelInfo() {
	}

	@Override
	public String getString(Object obj) {
		GameLevel gmLevel = (GameLevel) obj;
		return " " + gmLevel.level;
	}
}
