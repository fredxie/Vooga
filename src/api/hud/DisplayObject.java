package api.hud;

import java.awt.Graphics2D;

public class DisplayObject {
	private Graphics2D myGraphics;
	private String myFont;
	private String myTitle;
	private Display myDisplay;
	private int myX;
	private int myY;
	
	public DisplayObject() {
		myFont = myTitle = "";
		myX = myY = 0;
	}
	
	public DisplayObject(Graphics2D g, String font, String title, Display disp, int x, int y) {
		myGraphics = g;
		myFont = font;
		myTitle = title;
		myDisplay = disp;
		myX = x;
		myY = y;
	}
	
	public void changeFont(String font) {
		myFont = font;
	}
	
	public void changeTitle(String title) {
		myTitle = title;
	}
	
	public void changePosition (int x, int y) {
		myX = x;
		myY = y;
	}
	
	public void display() {	
		myDisplay.display(myGraphics, myFont, myTitle, myX, myY);
	}
}
