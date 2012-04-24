package hud;

import api.element.Fighter;

public class WeaponInfo implements HUDInfo {
	public WeaponInfo() {
	}

	@Override
	public String getString(Object obj) {
		Fighter fighter = (Fighter) obj;
		return " " + fighter.getWeaponStyle();
	}

}
