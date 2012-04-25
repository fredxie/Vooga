package demo.gameLevel;


import java.awt.Graphics2D;

import api.game.TopDownGameEngine;
import api.gameLevel.GameLevel;
import api.hud.HUD;
import api.state.DefaultLastLevelState;
import demo.HUD.DirectText;
import demo.HUD.FighterHPText;
import demo.HUD.LifeText;
import demo.HUD.ScoreText;
import demo.game.DemoGameEngine;
import demo.levelTransition.DemoLevelTransition;


public class GameLevel2 extends GameLevel {

	public GameLevel2(TopDownGameEngine parent) {
		super(parent);
		myState = new DefaultLastLevelState(parent, this);
		levelInit = new DemoLevelInit2(this);
		levelUpdate =new DemoLevelUpdate2(this);
		levelTransition =new DemoLevelTransition(this);
	}

	public void render(Graphics2D g) {
		playfield.render(g);
		HUD hud = new HUD();
		hud.addDisplayObject(g, fontManager, "FPS Font", levelRequirement, new DirectText(), 20, 15);
		hud.addDisplayObject(g, fontManager, "FPS Font", "ENEMY DESTROYED", new ScoreText(), 20, 30);
		hud.addDisplayObject(g, fontManager, "FPS Font", "PLAYER HP", new FighterHPText(fighter), 20, DemoGameEngine.HEIGHT - 15);
		hud.addDisplayObject(g, fontManager, "FPS Font", "PLAYER LIFE", new LifeText(fighter), DemoGameEngine.WIDTH / 2, DemoGameEngine.HEIGHT - 15);
		hud.display();	
	
	}

}
