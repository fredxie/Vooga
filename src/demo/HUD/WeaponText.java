package demo.HUD;

import api.element.Fighter;
import api.hud.DisplayText;


public class WeaponText extends DisplayText {
	private Fighter myFighter;
	
	public WeaponText(Fighter fighter) {
		super();
		myFighter = fighter;
	}
	
	@Override
	public String getString() {
		return " " + myFighter.getWeaponStyle();
	}

}
