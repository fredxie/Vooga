package gameObject.scoreBoardGameObject;

import game.TopDownGameEngine;
import gameObject.TopDownGameManager;

import java.awt.Graphics2D;

import state.DefaultInnerLevelState;

import background.TopDownImageBackground;

import collisionSystem.LifeDecreaseCollision;


import demo.DemoGameEngine;

public class InnerLevelScoreBoard extends ScoreBoardGameObject{
	TopDownImageBackground mainMenuTitle;

	public InnerLevelScoreBoard(TopDownGameEngine parent) {
		super(parent);
		myState = new DefaultInnerLevelState(parent,this);
	}

	public void initResources() {
		mainMenuTitle = new TopDownImageBackground(
				getImage("images/menu/title.png"), DemoGameEngine.WIDTH,
				DemoGameEngine.HEIGHT);
	}

	public void render(Graphics2D g) {
		mainMenuTitle.render(g);
		setOptionLayout(g,100,100,40);
		
	}

	public void setOutputContent() {
		addOutputContent("You finish Level "+(TopDownGameManager.getCurrentGameID()-TopDownGameManager.GAMELEVELBEGIN));
		addOutputContent("You killed "+ (LifeDecreaseCollision.destroyed) + " enemies");
	}

}
