package hud;

import element.Fighter;

public class HPInfo implements HUDInfo {
	public HPInfo() {}
	
	@Override
	public String getString(Object obj) {
		Fighter fighter = (Fighter) obj;
		return " " + fighter.getHP();
	}
}
