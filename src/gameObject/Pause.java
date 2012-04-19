package gameObject;

import game.TopDownGameEngine;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import state.PauseState;
import background.TopDownImageBackground;
import demo.DemoGameEngine;

public class Pause extends OptionGameObject {
	int option;
	TopDownImageBackground mainMenuTitle;

	public Pause(TopDownGameEngine parent) {
		super(parent);

		myState = new PauseState(parent, this);
	}
	
	public void setOptionList(){
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
		setOptionLayout(g,150,100,40);
		setOptionArrow(g);
	}

	public void setOptionArrow(Graphics2D g) {
		g.drawImage(getImage("images/menu/MenuArrow.png"), 110,
				90 + (super.getOption() * 40), null);
	}

	public void innerStateUpdate(long elapsedTime) {
		int keyInput =bsInput.getKeyPressed();
		optionArrowUp(keyInput,KeyEvent.VK_UP, 3);
		optionArrowDown(keyInput,KeyEvent.VK_DOWN, 3);
		setFinish(keyInput,KeyEvent.VK_ESCAPE);
	}

	public int getOption() {
		return super.getOption();
	}

}
