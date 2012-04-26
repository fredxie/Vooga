package demo.HUD;

import api.HUD.DisplayText;

public class NumberText extends DisplayText {
	private int myNumber;
	
	public NumberText(int num) {
		myNumber = num;		
	}
	
	@Override
	public String getString() {
		return " " + myNumber;
	}

}
