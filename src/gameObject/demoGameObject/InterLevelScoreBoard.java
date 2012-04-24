package gameObject.demoGameObject;

import game.TopDownGameEngine;
import gameObject.api_GameObject.ScoreBoardGameObject;
import gameObject.api_GameObject.TopDownGameManager;

import java.awt.Graphics2D;

import state.api.DefaultInterLevelState;

import background.TopDownImageBackground;
import collisionSystem.EnemyBulletCollision;


import demo.DemoGameEngine;

public class InterLevelScoreBoard extends ScoreBoardGameObject{
	TopDownImageBackground mainMenuTitle;

	public InterLevelScoreBoard(TopDownGameEngine parent) {
		super(parent);
		myState = new DefaultInterLevelState(parent,this);
	}

	public void initResources(){
		mainMenuTitle = new TopDownImageBackground(
				getImage("images/menu/title.png"), DemoGameEngine.WIDTH,
				DemoGameEngine.HEIGHT);
	}

	public void render(Graphics2D g) {
		mainMenuTitle.render(g);
		//setOptionLayout(g,20,DemoGameEngine.HEIGHT / 2-50,50);
		fontManager.getFont("FPS Font").drawString(g,
				"YOU FINISHED LEVEL " + (TopDownGameManager.getPreviousGameID()-TopDownGameManager.GAMELEVELBEGIN+1), 20,
				DemoGameEngine.HEIGHT / 2 - 50);
		fontManager.getFont("FPS Font").drawString(g,
				"YOU KILLED " + EnemyBulletCollision.destroyed+" ENEMIES", 20,
				DemoGameEngine.HEIGHT / 2 );
		
	}

}
