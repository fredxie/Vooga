package api.hud;

import java.awt.Graphics2D;

public abstract class Display {
	abstract public void display(Graphics2D g, String font, String title, int x, int y);
}
