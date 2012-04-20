package gameObject.optionGameObject;


import game.TopDownGameEngine;

import java.awt.Graphics2D;

import state.MenuState;
import background.TopDownImageBackground;
import demo.DemoGameEngine;

public class Menu extends OptionGameObject {
	int option;
	TopDownImageBackground mainMenuTitle;
	

	public Menu(TopDownGameEngine parent) {
		super(parent);
        myState = new MenuState(parent, this);
	}
	
	public void setOptionList(){
		addOption("PLAY");
		addOption("EXIT");
		addOption("LEVEL EDITOR");
		addOption("LOAD AND SAVE");
		addOption("SETTING");
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
		
		setOptionLayout(g,150,100,40);
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