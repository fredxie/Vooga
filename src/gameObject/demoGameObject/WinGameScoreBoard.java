package gameObject.demoGameObject;

import game.TopDownGameEngine;
import gameObject.api_GameObject.ScoreBoardGameObject;
import gameObject.api_GameObject.TopDownGameManager;

import java.awt.Graphics2D;

import state.api.DefaultFinishGameState;

import collisionSystem.EnemyBulletCollision;
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
				"YOU KILLED " + EnemyBulletCollision.destroyed + " ENEMIES", 20,
				DemoGameEngine.HEIGHT / 2 );
	}

	

}
