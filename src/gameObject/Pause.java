package gameObject;

/**
 * @author Jiawei Shi
 */

import game.TopDownGameEngine;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import demo.DemoGameEngine;

import state.PauseState;
import background.TopDownImageBackground;


public class Pause extends TopDownMenuObject{

	public Pause(TopDownGameEngine parent) {
		super(parent);
		myState = new PauseState(parent,this);
	}

	@Override
	public void setImageBackground() {
		mainMenuTitle = new TopDownImageBackground(
				getImage("images/menu/title.png"), DemoGameEngine.WIDTH,
				DemoGameEngine.HEIGHT);
	}

	@Override
	public void renderOptions(Graphics2D g) {
		fontManager.getFont("FPS Font").drawString(g, "RESUME", 150, 100);
		fontManager.getFont("FPS Font").drawString(g, "RESTART", 150, 140);
		fontManager.getFont("FPS Font").drawString(g, "SETTING", 150, 180);
		fontManager.getFont("FPS Font").drawString(g, "MENU", 150, 220);
	}

	@Override
	public void setOptionArrow(Graphics2D g) {
		g.drawImage(getImage("images/menu/MenuArrow.png"), 110,
				90 + (option * 40), null);
	}

	@Override
	public void innerStateUpdate(long elapsedTime) {
		optionArrowUp(KeyEvent.VK_UP,3);
		optionArrowDown(KeyEvent.VK_DOWN, 3);
		setFinish(KeyEvent.VK_ESCAPE);
		
	}
	
}


