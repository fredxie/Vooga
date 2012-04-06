/**
 * @author Jiawei Shi
 */

package demoState;

import game.Configuration;
import game.TopDownGameEngine;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import levelEditor.LevelEditor;
import levelEditor.Setting;
import menu.GameSL;

import demo.DemoGameEngine;
import element.Element;

import background.TopDownImageBackground;

public class MenuState extends State {

	int option;
	TopDownImageBackground mainMenuTitle;

	public MenuState(TopDownGameEngine parent) {
		super(parent);
		gameID = 0;
	}

	@Override
	public void initResources() {
		mainMenuTitle = new TopDownImageBackground(
				getImage("images/menu/title.png"), DemoGameEngine.WIDTH,
				DemoGameEngine.HEIGHT);
	}

	@Override
	public void update(long elapsedTime) {
		switch (bsInput.getKeyPressed()) {
		case KeyEvent.VK_ENTER:
		case KeyEvent.VK_SPACE:
			if (option == 0) {
				// start easy game
				parent.nextGameID = DemoGameEngine.GAME_Level1;
				finish();
			}

			if (option == 1) {
				// end
				finish();
			}
			if (option == 2) {
				// level editor
				LevelEditor l = new LevelEditor();
			}
			if (option == 3) {
				// load and start game
				GameSL sl = new GameSL();
				try {
					ArrayList<Element> list = sl.loadElement("1.jason");
					HashMap<Integer, String> map = sl.loadMap("1.jason");
					String path = map.get(0);
					Configuration.BACKGROUND_PATH = path;
				} catch (IOException e) {

				}
			}
			if (option == 4) {
				Setting setting = new Setting();
			}
			break;

		case KeyEvent.VK_UP:
			option--;
			// loop
			if (option < 0)
				option = 4;
			break;

		case KeyEvent.VK_DOWN:
			option++;
			if (option > 4)
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
		fontManager.getFont("FPS Font").drawString(g, "PLAY", 150, 100);
		fontManager.getFont("FPS Font").drawString(g, "EXIT", 150, 140);
		fontManager.getFont("FPS Font").drawString(g, "LEVEL EDITOR", 150, 180);
		fontManager.getFont("FPS Font").drawString(g, "LOAD AND START", 150,
				220);
		fontManager.getFont("FPS Font").drawString(g, "SETTING", 150,
				260);
		g.drawImage(getImage("images/menu/MenuArrow.png"), 110,
				90 + (option * 40), null);

	}

	@Override
	public boolean levelComplete() {
		// TODO Auto-generated method stub
		return false;
	}

}
