/**
 * @author Jiawei Shi
 */

package demoState;

import game.Configuration;
import game.TopDownGameEngine;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;


import background.TopDownImageBackground;

import demo.DemoGameEngine;

public class PauseState extends State{
	
	int option;
	TopDownImageBackground mainMenuTitle;

	public PauseState(TopDownGameEngine parent) {
		super(parent);
	}

	@Override
	public void initResources() {
		mainMenuTitle = new TopDownImageBackground(getImage("images/menu/title.png"),
				DemoGameEngine.WIDTH, DemoGameEngine.HEIGHT);
	}

	@Override
	public void update(long elapsedTime) {
		switch (bsInput.getKeyPressed()) {
		case KeyEvent.VK_ENTER:
		case KeyEvent.VK_SPACE:
			if (option == 0) {
				// RESUME
				parent.nextGameID = DemoGameEngine.Playing;
				finish();
			}

			if (option == 1) {
				// RESTART
				parent.initResources();
				parent.nextGameID = DemoGameEngine.Playing;
				finish();
			}
			if (option == 2) {
				// Setting
				System.out.println("setting");
			}
			if (option == 3){
				// menu
				parent.initResources();
				parent.nextGameID = DemoGameEngine.Menu;
				finish();
			}
			break;

		case KeyEvent.VK_UP:
			option--;
			// loop
			if (option < 0)
				option = 3;
			break;

		case KeyEvent.VK_DOWN:
			option++;
			if (option > 3)
				option = 0;
			break;

		case KeyEvent.VK_ESCAPE:
			finish();
			break;
		}		
	}

	@Override
	public void render(Graphics2D g) {
		mainMenuTitle.render(g);
		fontManager.getFont("FPS Font").drawString(g, "RESUME", 150, 100);
		fontManager.getFont("FPS Font").drawString(g, "RESTART", 150, 140);
		fontManager.getFont("FPS Font").drawString(g, "SETTING", 150, 180);
		fontManager.getFont("FPS Font").drawString(g, "MENU", 150, 220);
		g.drawImage(getImage("images/menu/MenuArrow.png"), 110, 90 + (option * 40), null);
		
	}

}
