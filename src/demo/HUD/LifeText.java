package demo.HUD;

import api.element.Fighter;
import api.hud.DisplayText;


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
