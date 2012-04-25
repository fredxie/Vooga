package api.hud;

import java.awt.Graphics2D;

import com.golden.gamedev.object.GameFontManager;

public abstract class DisplayGraph extends Display {
	private GameFontManager myFontManager;
	
	public DisplayGraph () {
		myFontManager = new GameFontManager();
	}

	@Override
	public void display(Graphics2D g, String font, String title, int x, int y) {
		myFontManager.getFont(font).drawString(g, title, x, y);
		
		this.placeGraph(x, y, myFontManager.getFont(font).getWidth(title));
		
	}
	
	abstract void placeGraph(int length, int x, int y);

}
