package demo;


import element.Element;
import game.Configuration;
import game.TopDownGameEngine;
import game.TopDownGameObject;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import levelEditor.LevelEditor;
import menu.GameSL;

import background.TopDownImageBackground;


public class DemoMenu extends TopDownGameObject {

	{
		hideCursor();
	}
	
	int option;
	TopDownImageBackground mainMenuTitle;

	public DemoMenu(TopDownGameEngine parent) {
		super(parent);
	}

	public void initResources() {

		mainMenuTitle = new TopDownImageBackground(getImage("images/menu/title.png"),
				DemoGameEngine.WIDTH, DemoGameEngine.HEIGHT);
	}

	public void update(long elapsedTime) {

		switch (bsInput.getKeyPressed()) {
		case KeyEvent.VK_ENTER:
		case KeyEvent.VK_SPACE:
			if (option == 0) {
				// start easy game
				parent.nextGameID = DemoGameEngine.Playing;
				finish();
			}
//			if (option == 1) {
//				// start hard game
//				parent.nextGameID = DemoGameEngine.HARD_GAME;
//				finish();
//			}
			if (option == 1) {
				// end
				finish();
			}
			if (option == 2) {
				// level editor
				LevelEditor l = new LevelEditor();
			}
			if (option == 3){
				// load and start game
				GameSL sl = new GameSL();
				try{
				ArrayList<Element> list = sl.loadElement("1.jason");
				HashMap<Integer,String> map= sl.loadMap("1.jason");
				String path = map.get(0);
				
//				for(Element i: list)
//				{
//					if(i instanceof DemoEnemy) 
//					Configuration.ENEMY_PATH=i.getImage();	
//					if(i instanceof DemoFighter)
//					Configuration.FIGHTER_PATH=i.getImage();
//				}
				Configuration.BACKGROUND_PATH = path;
				}
				catch(IOException e){
					
				}
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

	public void render(Graphics2D g) {

		mainMenuTitle.render(g);
		fontManager.getFont("FPS Font").drawString(g, "EASY", 150, 100);
//		fontManager.getFont("FPS Font").drawString(g, "HARD", 150, 140);
		fontManager.getFont("FPS Font").drawString(g, "EXIT", 150, 140);
		fontManager.getFont("FPS Font").drawString(g, "LEVEL EDITOR", 150, 180);
		fontManager.getFont("FPS Font").drawString(g, "LOAD AND START", 150, 220);
		g.drawImage(getImage("images/menu/MenuArrow.png"), 110, 90 + (option * 40), null);
	}

} 