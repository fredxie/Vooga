package levelTransition;

import java.awt.Graphics2D;

import collisionSystem.EnemyBulletCollision;
import collisionSystem.LifeDecreaseCollision;

import com.golden.gamedev.object.GameFontManager;

import demo.DemoGameEngine;

public class DemoLevelTransition1 extends LevelTransition {

	/*public void levelComplete(boolean lc) {
		if (EnemyBulletCollision.destroyed >= 2) {
			lc = true;
		}
	}*/

	public void gameRender(Graphics2D g, String levelRequirement,
			GameFontManager fontManager) {
		fontManager.getFont("FPS Font").drawString(g, levelRequirement, 20, 15);
		fontManager.getFont("FPS Font").drawString(g,
				"ENEMIES DESTROYED   " + LifeDecreaseCollision.destroyed, 20,
				30);

	}

	public void betweenLevelsRender(Graphics2D g, int nextLevelNum,
			GameFontManager fontManager) {
		fontManager.getFont("FPS Font").drawString(g,
				"ENEMIES DESTROYED   " + LifeDecreaseCollision.destroyed, 20,
				DemoGameEngine.HEIGHT / 2 - 50);
		fontManager.getFont("FPS Font").drawString(g, "MISSION COMPLETE!   ",
				20, DemoGameEngine.HEIGHT / 2);
		fontManager.getFont("FPS Font").drawString(g,
				"COMING: LEVEL" + " " + nextLevelNum + "       ", 20,
				DemoGameEngine.HEIGHT / 2 + 50);

	}

	public void gameOverRender(Graphics2D g, GameFontManager fontManager) {
		fontManager.getFont("FPS Font").drawString(g,
				"GAME OVER! PRESS ESC TO QUIT", 20, DemoGameEngine.HEIGHT / 2);
	}
}
