package api.hud;

import java.awt.Graphics2D;

import com.golden.gamedev.object.GameFontManager;

public abstract class Display {
	abstract public void display(Graphics2D g, GameFontManager fontManager, String font, String title, int x, int y);
}
