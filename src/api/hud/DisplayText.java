package api.hud;

import java.awt.Graphics2D;

import com.golden.gamedev.object.GameFontManager;

public abstract class DisplayText extends Display{
	private GameFontManager myFontManager;
	
	public DisplayText() {
		myFontManager = new GameFontManager();
	}
	
	public void display(Graphics2D g, String font, String title, int x, int y) {
		myFontManager.getFont(font).drawString(g, title + this.getString(), x, y);
	}
	
	abstract String getString();
}