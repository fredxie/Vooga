package gameObject.demoGameObject;


import game.TopDownGameEngine;
import gameObject.api_GameObject.OptionGameObject;

import java.awt.Graphics2D;

import state.api_State.State;
import state.demoState.PauseState;
import background.TopDownImageBackground;
import demo.DemoGameEngine;

public class Pause extends OptionGameObject{
	int option;
	TopDownImageBackground mainMenuTitle;

	public Pause(TopDownGameEngine parent) {
		super(parent);

		myState = new PauseState(parent, this);
	}

	public void setOptionList() {
		addOption("RESUME");
		addOption("RESTART");
		addOption("SETTING");
		addOption("MENU");
	}

	public void initResources() {
		mainMenuTitle = new TopDownImageBackground(
				getImage("images/menu/title.png"), DemoGameEngine.WIDTH,
				DemoGameEngine.HEIGHT);

	}

	public void render(Graphics2D g) {
		mainMenuTitle.render(g);
		setOptionLayout(g, 150, 100, 40);
		setOptionArrow(g);
	}

	public void setOptionArrow(Graphics2D g) {
		g.drawImage(getImage("images/menu/MenuArrow.png"), 110,
				90 + (super.getOption() * 40), null);
	}

	public int getOption() {
		return super.getOption();
	}
	
	public State getState(){
		return myState;
	}


}
