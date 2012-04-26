package levelEditor;

import java.awt.Graphics2D;
import java.util.List;

import api.HUD.HUD;
import api.game.TopDownGameEngine;
import api.gameLevel.GameLevel;
import api.state.DefaultLastLevelState;
import demo.HUD.DirectText;
import demo.HUD.ScoreText;
import demo.gameLevel.DemoLevelUpdate1;
import demo.levelTransition.DemoLevelTransition;

public class MyOwnGameLevel extends GameLevel {

	public List<List<Object>> list;

	public MyOwnGameLevel(TopDownGameEngine parent) {
		super(parent);
		myState = new DefaultLastLevelState(parent, this);
		levelInit = new MyOwnGameLevelInit(this);
		levelUpdate = new DemoLevelUpdate1 (this);
		levelTransition = new DemoLevelTransition(this);
	}

	public void render(Graphics2D g) {
		playfield.render(g);
		HUD hud = new HUD();
		hud.addDisplayObject(g, fontManager, "FPS Font", levelRequirement, new DirectText(), 20, 15);
		hud.addDisplayObject(g, fontManager, "FPS Font", "ENEMY DESTROYED", new ScoreText(), 20, 30);
		hud.display();
	}

}
