package api.hud;

import api.element.Fighter;


public class LifeText extends DisplayText {
	private Fighter myFighter;
	public LifeText(Fighter fighter) {
		super();
		myFighter = fighter;
	}
	
	@Override
	public String getString() {
		return " " + myFighter.getLifeNum();
	}

}
