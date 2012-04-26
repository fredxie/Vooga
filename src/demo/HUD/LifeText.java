package demo.HUD;

import api.HUD.DisplayText;
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
