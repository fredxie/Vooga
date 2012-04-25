package api.hud;

import api.element.Fighter;



public class FighterHPText extends DisplayText {
	private Fighter myFighter;
	public FighterHPText(Fighter fighter) {
		super();
		myFighter = fighter;
	}
	
	@Override
	public String getString() {
		return " " + myFighter.getHP();
	}
}
