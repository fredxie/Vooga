package demo.gameLevel;

import java.awt.Graphics2D;

import api.game.TopDownGameEngine;
import api.gameLevel.GameLevel;
import api.hud.HUD;
import api.state.DefaultLevelState;
import demo.HUD.DirectText;
import demo.HUD.FighterHPText;
import demo.HUD.LifeText;
import demo.HUD.ScoreText;
import demo.game.DemoGameEngine;
import demo.levelTransition.DemoLevelTransition;

public class GameLevel1 extends GameLevel {

	public GameLevel1(TopDownGameEngine parent) {
		super(parent);
		myState = new DefaultLevelState(parent, this);
		levelInit = new DemoLevelInit1(this);
		levelUpdate =new DemoLevelUpdate1(this);
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
