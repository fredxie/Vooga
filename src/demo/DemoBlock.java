package demo;

import java.awt.image.BufferedImage;

import util.TopDownUtility;

import element.Block;
import element.TopDownPlayField;

public class DemoBlock extends Block {

	public DemoBlock(TopDownPlayField playfield, BufferedImage image) {
		super(playfield, image);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {

		this.setX(TopDownUtility.getRandom(0,
				DemoGameEngine.WIDTH - this.getWidth()));
		this.setY(TopDownUtility.getRandom(150, playfield.getBackground()
				.getHeight() - DemoGameEngine.HEIGHT));
		playfield.getGroup("Block").add(this);
	}

}
