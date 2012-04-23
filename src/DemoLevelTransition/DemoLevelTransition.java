package DemoLevelTransition;

import gameLevel.GameLevel;

import java.awt.Graphics2D;

import levelTransition.LevelTransition;
import collisionSystem.EnemyBulletCollision;
import demo.DemoGameEngine;

public class DemoLevelTransition extends LevelTransition {

	public DemoLevelTransition(GameLevel gl) {
		super(gl);
	}

	public void levelCompleteRender(Graphics2D g) {
		gl.fontManager.getFont("FPS Font").drawString(g,
				"ENEMIES DESTROYED   " + EnemyBulletCollision.destroyed, 20,
				DemoGameEngine.HEIGHT / 2 - 50);
		gl.fontManager.getFont("FPS Font").drawString(g,
				"MISSION COMPLETE!   ", 20, DemoGameEngine.HEIGHT / 2);
		gl.fontManager.getFont("FPS Font").drawString(g,
				"COMING: LEVEL" + " " + gl.level + 1 + "       ", 20,
				DemoGameEngine.HEIGHT / 2 + 50);

	}

	public void gameOverRender(Graphics2D g) {
		gl.fontManager.getFont("FPS Font").drawString(g,
				"GAME OVER! PRESS ESC TO QUIT", 20, DemoGameEngine.HEIGHT / 2);
	}


	public void gameOver() {

		if (gl.fighter.getLifeNum() == 0) {
			gl.gameOver = true;
			gl.playfield.clearPlayField();
		}

	}

}
