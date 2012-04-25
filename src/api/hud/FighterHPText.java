package api.hud;

import api.element.Fighter;



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
