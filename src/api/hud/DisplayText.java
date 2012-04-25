package api.hud;

import java.awt.Graphics2D;

import com.golden.gamedev.object.GameFontManager;

public abstract class DisplayText extends Display{
	public DisplayText() {}
	
	public void display(Graphics2D g, GameFontManager fontManager, String font, String title, int x, int y) {
		fontManager.getFont(font).drawString(g, title + this.getString(), x, y);
	}
	
	public abstract String getString();
}