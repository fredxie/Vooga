package hud;

import gameObject.GameLevel;

public class LevelInfo implements HUDInfo {
	public LevelInfo() {}
	
	@Override
	public String getString(Object obj) {
		GameLevel gmLevel = (GameLevel) obj;
		return " " + gmLevel.Level;
	}
}
