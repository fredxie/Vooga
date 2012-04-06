package hud;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.golden.gamedev.object.GameFontManager;

public class HUD {

	private String myFont;
	private String myTitle;
	private Object myObject;
	private String myInfoType;
	private int myX;
	private int myY;
	private ArrayList<Object[]> myData;
	private GameFontManager fontManager;
	private Graphics2D myGraphic;
	
	public HUD() {
//		myFont = "";
//		title = "";
//		parameter = null;
//		x=y=0;
//		myData = new ArrayList<Object[]>();
	}
	public HUD(Graphics2D g, String font, String title, String type, Object para, int x, int y) {
		myFont = font;
		myTitle = title;
		myInfoType = type;
		myObject = para;
		myX = x;
		myY = y;
		myGraphic = g;
	}
	
	public HUD(Graphics2D g, String font, String title, int x, int y) {
		myFont = font;
		myTitle = title;
		myObject = null;
		myX = x;
		myY = y;
		myGraphic = g;
	}
	
	public HUD(Graphics2D g, ArrayList<Object[]> data) {
		myData = data;
		myGraphic = g;
	}
	
	public HUD(Graphics2D g, String font, ArrayList<Object[]> data) {
		myFont = font;
		myData = data;
		myGraphic = g;
	}
	
	public void DisplayMono() {
		if(myObject == null) {
			fontManager.getFont(myFont).drawString(myGraphic, myTitle, myX, myY);
		}
		else {
		InfoFactory info = new InfoFactory(myInfoType, myObject);
		fontManager.getFont(myFont).drawString(myGraphic, myTitle + info.getInfo(), myX, myY);
		}
	}
	
	public void DisplayMulti() {
		for(Object[] obj : myData) {
			if(obj.length == 3){
				fontManager.getFont(myFont).drawString(myGraphic,(String) obj[0], Integer.parseInt(obj[1].toString()), Integer.parseInt(obj[2].toString()));
			}
			else if(obj.length == 4) {
				fontManager.getFont((String) obj[0]).drawString(myGraphic, (String) obj[1],Integer.parseInt(obj[2].toString()), Integer.parseInt(obj[3].toString()));
			}
			else if(obj.length == 5) {
				InfoFactory info = new InfoFactory(obj[1].toString(), obj[2]);
				fontManager.getFont(myFont).drawString(myGraphic,obj[0].toString() + info.getInfo(), Integer.parseInt(obj[3].toString()), Integer.parseInt(obj[4].toString()));
			}
			else if(obj.length == 6) {
				InfoFactory info = new InfoFactory((String) obj[2], obj[3]);
				fontManager.getFont((String) obj[0]).drawString(myGraphic,(String) obj[1] + info.getInfo(), Integer.parseInt(obj[4].toString()), Integer.parseInt(obj[5].toString()));
			}
		}
	}
	
	public void add(Object[] data) {
		myData.add(data);
	}
	
	public void clearHUD() {
		myGraphic = null;
		myFont = null;
		myData = new ArrayList<Object[]>();
	}

}
