package demo.gameObject;


import java.awt.Graphics2D;

import api.HUD.HUD;
import api.background.TopDownImageBackground;
import api.game.TopDownGameEngine;
import api.gameObject.ScoreBoardGameObject;
import api.gameObject.TopDownGameManager;
import api.state.DefaultFinishGameState;
import demo.HUD.NumberText;
import demo.HUD.ScoreText;
import demo.game.DemoGameEngine;

public class LostGameScoreBoard extends ScoreBoardGameObject {
	TopDownImageBackground mainMenuTitle;

	public LostGameScoreBoard(TopDownGameEngine arg0) {
		super(arg0);
		myState = new DefaultFinishGameState(arg0, this);
	}

	public void initResources() {
		mainMenuTitle = new TopDownImageBackground(
				getImage("images/menu/title.png"), DemoGameEngine.WIDTH,
				DemoGameEngine.HEIGHT);
	}

	public void render(Graphics2D g) {
		mainMenuTitle.render(g);
		HUD hud = new HUD();
		hud.addDisplayObject(g, fontManager, "FPS Font", "YOU LOST IN THE LEVEL", new NumberText(TopDownGameManager.getPreviousGameID()
				- TopDownGameManager.GAMELEVELBEGIN + 1), 20, DemoGameEngine.HEIGHT / 2 - 50);
		hud.addDisplayObject(g, fontManager, "FPS Font", "NUMBER OF ENEMIES KILLED", new ScoreText(), 20, DemoGameEngine.HEIGHT / 2);
		hud.display();
	}

}
