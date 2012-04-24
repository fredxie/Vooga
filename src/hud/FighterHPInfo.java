package hud;

import api.element.Fighter;

public class FighterHPInfo implements HUDInfo {
	public FighterHPInfo() {
	}

	@Override
	public String getString(Object obj) {
		return " " + Fighter.getHP();
	}
}
