package hud;

import state.State;

public class LevelInfo implements HUDInfo {
	public LevelInfo() {}
	
	@Override
	public String getString(Object obj) {
		State state = (State) obj;
		return " " + state.getStateID();
	}
}
