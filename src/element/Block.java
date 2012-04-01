package element;

import java.awt.image.BufferedImage;

public abstract class Block extends Element{

	public Block(BufferedImage image){
		super(image);
	}
	
	public boolean show = false;

	public Block(TopDownPlayField playfield,BufferedImage image){
		super(image);
		this.playfield = playfield;
	}

	@Override
	public abstract void init();
}
