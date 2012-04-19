package gameObject.scoreBoardGameObject;

import game.TopDownGameEngine;
import gameObject.TopDownGameManager;

import java.awt.Graphics2D;

import state.DefaultFinishGameState;

import background.TopDownImageBackground;

import collisionSystem.LifeDecreaseCollision;

import demo.DemoGameEngine;

public class LostGameScoreBoard extends ScoreBoardGameObject {
	TopDownImageBackground mainMenuTitle;
	
	public LostGameScoreBoard(TopDownGameEngine arg0) {
		super(arg0);
		myState = new DefaultFinishGameState(arg0,this);
	}

	public void initResources() {
		mainMenuTitle = new TopDownImageBackground(
				getImage("images/menu/title.png"), DemoGameEngine.WIDTH,
				DemoGameEngine.HEIGHT);
	}

	public void render(Graphics2D g) {
		mainMenuTitle.render(g);
		fontManager.getFont("FPS Font").drawString(g,
				"YOU LOST IN THE LEVEL " + (TopDownGameManager.getPreviousGameID()-TopDownGameManager.GAMELEVELBEGIN+1), 20,
				DemoGameEngine.HEIGHT / 2 - 50);
		fontManager.getFont("FPS Font").drawString(g,
				"YOU KILLED " + LifeDecreaseCollision.destroyed + " ENEMIES", 20,
				DemoGameEngine.HEIGHT / 2 );
	}

	

}
