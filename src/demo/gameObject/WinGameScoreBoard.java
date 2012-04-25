package demo.gameObject;


import java.awt.Graphics2D;

import api.background.TopDownImageBackground;
import api.game.TopDownGameEngine;
import api.gameObject.ScoreBoardGameObject;
import api.hud.HUD;
import api.state.DefaultFinishGameState;
import demo.HUD.DirectText;
import demo.game.DemoGameEngine;

public class WinGameScoreBoard extends ScoreBoardGameObject {

	TopDownImageBackground mainMenuTitle;

	public WinGameScoreBoard(TopDownGameEngine parent) {
		super(parent);
		myState = new DefaultFinishGameState(parent, this);
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
		HUD hud = new HUD();
		hud.addDisplayObject(g, fontManager, "FPS Font", "YOU WIN THE GAME!", new DirectText(), 20, DemoGameEngine.HEIGHT / 2 - 50);
		hud.addDisplayObject(g, fontManager, "FPS Font", "NUMBER OF ENEMIES KILLED", new DirectText(), 20, DemoGameEngine.HEIGHT / 2);
		hud.display();
	}

}
