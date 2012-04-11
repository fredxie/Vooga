package gameObject;


import game.TopDownGameEngine;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import state.MenuState;
import background.TopDownImageBackground;
import demo.DemoGameEngine;

public class Menu extends TopDownGameObject {
	int option;
	TopDownImageBackground mainMenuTitle;

	public Menu(TopDownGameEngine parent) {
		super(parent);
        myState = new MenuState(parent, this);
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
		fontManager.getFont("FPS Font").drawString(g, "PLAY", 150, 100);
		fontManager.getFont("FPS Font").drawString(g, "EXIT", 150, 140);
		fontManager.getFont("FPS Font").drawString(g, "LEVEL EDITOR", 150, 180);
		fontManager.getFont("FPS Font").drawString(g, "LOAD AND START", 150,220);
		fontManager.getFont("FPS Font").drawString(g, "SETTING", 150, 260);
		setOptionArrow(g);
	}

	public void setOptionArrow(Graphics2D g) {
		g.drawImage(getImage("images/menu/MenuArrow.png"), 110,
				90 + (super.getOption() * 40), null);
	}
	
	public void innerStateUpdate(long elapsedTime) {
		optionArrowUp(bsInput.getKeyPressed(),KeyEvent.VK_UP,4);
		optionArrowDown(bsInput.getKeyPressed(),KeyEvent.VK_DOWN, 4);
		setFinish(bsInput.getKeyPressed(),KeyEvent.VK_ESCAPE);

	}

	public int getOption() {
		return super.getOption();
	}

}
