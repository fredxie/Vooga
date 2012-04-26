package api.HUD;

import java.awt.Graphics2D;

import com.golden.gamedev.object.GameFontManager;

public abstract class DisplayImage extends Display {	
	public DisplayImage () {}

	@Override
	public void display(Graphics2D g, GameFontManager fontManager, String font, String title, int x, int y) {
		fontManager.getFont(font).drawString(g, title, x, y);
		
		this.placeGraph(x, y, fontManager.getFont(font).getWidth(title));
		
	}
	
	public abstract void placeGraph(int length, int x, int y);

}
