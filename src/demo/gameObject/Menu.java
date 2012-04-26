package demo.gameObject;


import java.awt.Graphics2D;

import api.background.TopDownImageBackground;
import api.game.TopDownGameEngine;
import api.gameObject.OptionGameObject;
import demo.game.DemoGameEngine;
import demo.state.MenuState;

public class Menu extends OptionGameObject {
	private TopDownImageBackground mainMenuTitle;

	public Menu(TopDownGameEngine parent) {
		super(parent);
		myState = new MenuState(parent, this);
	}

	public void setOptionList() {
		addOption("PLAY");
		addOption("LEVEL EDITOR");
		addOption("LOAD FILE");
		addOption("PLAY MY OWN GAME");
		addOption("SETTING");
		addOption("EXIT");
	}

	@Override
	public void initResources() {
		mainMenuTitle = new TopDownImageBackground(
				getImage("images/menu/title.png"), DemoGameEngine.WIDTH,
				DemoGameEngine.HEIGHT);

	}

	@Override
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
	
}
