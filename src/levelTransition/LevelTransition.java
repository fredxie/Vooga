package levelTransition;

import java.awt.Graphics2D;

import com.golden.gamedev.object.GameFontManager;

public abstract class LevelTransition {
	
	//public abstract void levelComplete(boolean lc);

	public abstract void gameRender(Graphics2D g, String levelRequirement, GameFontManager fontManager);

	public abstract void betweenLevelsRender(Graphics2D g, int nextLevelNum, GameFontManager fontManager);
	
	public abstract void gameOverRender(Graphics2D g, GameFontManager fontManager);
}
