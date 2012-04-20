package gameLevel;

import game.TopDownGameEngine;
import gameObject.TopDownGameObject;

import java.awt.Graphics2D;

import demo.DemoGameEngine;

public abstract class GameLevel extends TopDownGameObject {

	public boolean gameOver = false;
	public String levelRequirement;
	public static int Level;
	public boolean levelComplete =false;
    
	public GameLevel(TopDownGameEngine parent) {
		super(parent);
	}

	public static int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		Level = level;
	}
	
	public boolean isGameOver(){
		return gameOver;
	}
	public abstract boolean levelComplete();// level complete requirement
}
