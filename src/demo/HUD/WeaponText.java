package demo.HUD;

import api.HUD.DisplayText;
import api.element.Fighter;


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
