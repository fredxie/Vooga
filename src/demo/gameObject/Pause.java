package demo.gameObject;


import java.awt.Graphics2D;

import api.background.TopDownImageBackground;
import api.game.TopDownGameEngine;
import api.gameObject.OptionGameObject;
import api.state.State;
import demo.game.DemoGameEngine;
import demo.state.PauseState;

public class Pause extends OptionGameObject {
	private TopDownImageBackground mainMenuTitle;

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

	public State getState() {
		return myState;
	}

}
