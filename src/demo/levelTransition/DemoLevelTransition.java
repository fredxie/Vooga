package demo.levelTransition;


import java.awt.Graphics2D;

import api.HUD.HUD;
import api.gameLevel.GameLevel;
import api.levelTransition.LevelTransition;
import demo.HUD.DirectText;
import demo.HUD.LevelText;
import demo.HUD.ScoreText;
import demo.game.DemoGameEngine;

public class DemoLevelTransition extends LevelTransition {

	public DemoLevelTransition(GameLevel gl) {
		super(gl);
	}

	public void levelCompleteRender(Graphics2D g) {
		HUD hud = new HUD();
		hud.addDisplayObject(g, gl.fontManager, "FPS Font", "ENEMIES DESTROYED", new ScoreText(), 20, DemoGameEngine.HEIGHT / 2 - 50);
		hud.addDisplayObject(g, gl.fontManager, "FPS Font", "MISSION COMPLETE!", new DirectText(), 20, DemoGameEngine.HEIGHT / 2);
		hud.addDisplayObject(g, gl.fontManager, "FPS Font", "COMING LEVEL", new LevelText(gl), 20, DemoGameEngine.HEIGHT / 2 + 50);
		hud.display();
	}

	public void gameOverRender(Graphics2D g) {
		HUD hud = new HUD();
		hud.addDisplayObject(g, gl.fontManager, "FPS Font", "GAME OVER! PRESS ESC TO QUIT", new DirectText(), 20, DemoGameEngine.HEIGHT / 2);
		hud.display();
	}


}
