package hud;

import element.Fighter;

public class LifeInfo implements HUDInfo {
	public LifeInfo() {}
	
	@Override
	public String getString(Object obj) {
		Fighter fighter = (Fighter) obj;
		return " " + fighter.getLifeNum();
	}

}
