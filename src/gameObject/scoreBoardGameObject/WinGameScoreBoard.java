package gameObject.scoreBoardGameObject;

import game.TopDownGameEngine;
import gameObject.TopDownGameManager;

import java.awt.Graphics2D;

import state.DefaultFinishGameState;

import collisionSystem.LifeDecreaseCollision;

import background.TopDownImageBackground;

import demo.DemoGameEngine;

public class WinGameScoreBoard extends ScoreBoardGameObject{
	
	TopDownImageBackground mainMenuTitle;

	public WinGameScoreBoard(TopDownGameEngine parent) {
		super(parent);
		myState = new DefaultFinishGameState(parent,this);
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
		fontManager.getFont("FPS Font").drawString(g,
				"YOU WIN THE GAME " , 20,
				DemoGameEngine.HEIGHT / 2 - 50);
		fontManager.getFont("FPS Font").drawString(g,
				"YOU KILLED " + LifeDecreaseCollision.destroyed + " ENEMIES", 20,
				DemoGameEngine.HEIGHT / 2 );
	}

	

}
