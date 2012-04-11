package gameObject;

/**
 * @author Jiawei Shi
 */

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import game.TopDownGameEngine;
import state.MenuState;
import background.TopDownImageBackground;
import demo.DemoGameEngine;


public class Menu extends TopDownMenuObject{

	public Menu(TopDownGameEngine parent) {
		super(parent);
		myState = new MenuState(parent,this);
	}

	@Override
	public void setImageBackground() {
		mainMenuTitle = new TopDownImageBackground(
				getImage("images/menu/title.png"), DemoGameEngine.WIDTH,
				DemoGameEngine.HEIGHT);
	}

	@Override
	public void renderOptions(Graphics2D g) {
		fontManager.getFont("FPS Font").drawString(g, "PLAY", 150, 100);
		fontManager.getFont("FPS Font").drawString(g, "EXIT", 150, 140);
		fontManager.getFont("FPS Font").drawString(g, "LEVEL EDITOR", 150, 180);
		fontManager.getFont("FPS Font").drawString(g, "LOAD AND START", 150,
				220);
		fontManager.getFont("FPS Font").drawString(g, "SETTING", 150,
				260);
		
	}

	@Override
	public void setOptionArrow(Graphics2D g) {
		g.drawImage(getImage("images/menu/MenuArrow.png"), 110,
				90 + (option * 40), null);
	}

	@Override
	public void innerStateUpdate(long elapsedTime) {
		optionArrowUp(KeyEvent.VK_UP,4);
		optionArrowDown(KeyEvent.VK_DOWN, 4);
		setFinish(KeyEvent.VK_ESCAPE);
	}
	
}
