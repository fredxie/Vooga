package api.element;

import java.awt.image.BufferedImage;

import api.game.TopDownPlayField;

import com.golden.gamedev.object.PlayField;

@SuppressWarnings("serial")
public class HUDGraph extends Element {
	private BufferedImage myImg;
	private int myX;
	private int myY;
	
	
	public HUDGraph(BufferedImage img, PlayField plyfield, int x, int y) {
		super(img);
		this.playfield = (TopDownPlayField) plyfield;
		myImg = img;
	}


	@Override
	public void init() {
		this.setX((double) myX );
		this.setY((double) myY );
		playfield.add(this);	
	}


	@Override
	public Element clone() {
		return new HUDGraph(this.myImg, this.playfield, this.myX, this.myY);
	}
	
	

}
