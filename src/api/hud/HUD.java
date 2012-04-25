package api.hud;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.golden.gamedev.object.GameFontManager;

public class HUD {
	private ArrayList<DisplayObject> myList;
	
	public HUD() {
		myList = new ArrayList<DisplayObject>();
	}
	
	public void addDisplayObject(Graphics2D g, GameFontManager fontManager, String font, String title, Display dis, int x, int y) {
		DisplayObject display = new DisplayObject(g, fontManager, font, title, dis, x, y);
		myList.add(display);
	}
	
	public void addDisplayObject(ArrayList<DisplayObject> list) {
		for (DisplayObject dis : list) {
			if(!myList.contains(dis)) {
				myList.add(dis);
			}
		}
	}
	
	public void removeDisplayObject(DisplayObject obj) {
		if(myList.contains(obj)) {
			myList.remove(obj);
		}
	}
	
	public boolean containsObject(DisplayObject obj) {
		return myList.contains(obj);
	}
	
	public void clearHUD() {
		myList = new ArrayList<DisplayObject>();
	}
	
	public void display() {
		for(DisplayObject obj : myList) {
			obj.display();
		}
	}
	
}
