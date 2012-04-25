package demo.HUD;



import java.awt.image.BufferedImage;

import api.element.Fighter;
import api.element.HUDGraph;
import api.hud.DisplayImage;

import com.golden.gamedev.object.PlayField;


public class LifeGraph extends DisplayImage {
	private BufferedImage myImage;
	private Fighter myFighter;
	private PlayField myField;
	
	public LifeGraph(Fighter fighter, BufferedImage img, PlayField plyfield) {
		super();
		myFighter = fighter;
		myImage = img;
		myField = plyfield;
	}
	
	@Override
	public void placeGraph(int length, int x, int y) {
		int lifeNum = myFighter.getLifeNum();
		for(int i = 0; i < lifeNum; i++) {
			@SuppressWarnings("unused")
			HUDGraph hdgp = new HUDGraph (myImage, myField, x + length + i * myImage.getWidth(), y);
		}
	}

}
