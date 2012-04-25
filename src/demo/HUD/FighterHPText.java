package demo.HUD;

import api.element.Fighter;
import api.hud.DisplayText;

public class FighterHPText extends DisplayText {
	private Fighter myFighter;
	public FighterHPText(Fighter fighter) {
		super();
		myFighter = fighter;
	}
	
	@SuppressWarnings("static-access")
	public String getString() {
		return " " + myFighter.getHP();
	}
}
