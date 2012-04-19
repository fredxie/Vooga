package gameObject.scoreBoardGameObject;

import gameObject.TopDownGameManager;

import java.awt.Graphics2D;

import background.TopDownImageBackground;

import collisionSystem.LifeDecreaseCollision;

import com.golden.gamedev.GameEngine;

import demo.DemoGameEngine;

public class LostGameObject extends ScoreBoardGameObject {
	TopDownImageBackground mainMenuTitle;
	
	public LostGameObject(GameEngine arg0) {
		super(arg0);
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

	@Override
	public void setOutputContent() {
		addOutputContent("You Lost in the level "+ (TopDownGameManager.getCurrentGameID()- TopDownGameManager.GAMELEVELBEGIN));
		addOutputContent("You killed "+ (LifeDecreaseCollision.destroyed) + " enemies");	
	}

}
