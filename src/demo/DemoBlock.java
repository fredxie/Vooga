<<<<<<< HEAD
package demo;

import java.awt.image.BufferedImage;

import util.TopDownUtility;

import element.Block;
import element.Element;
import element.TopDownPlayField;

public class DemoBlock extends Block {

	public DemoBlock(TopDownPlayField playfield, BufferedImage image,
			int hardDegree) {
		super(playfield, image);
		this.hardDegree = hardDegree;
		destroyable = true;
	}

	public DemoBlock(TopDownPlayField playfield, BufferedImage image) {
		super(playfield, image);
		destroyable = false;
	}

	@Override
	public void init() {

		this.setX(TopDownUtility.getRandom(0,
				DemoGameEngine.WIDTH - this.getWidth()));
		this.setY(TopDownUtility.getRandom(150, playfield.getBackground()
				.getHeight() - DemoGameEngine.HEIGHT));
		playfield.getGroup("Block").add(this);
	}

	@Override
	public Element clone() {
		// TODO Auto-generated method stub
		return null;
	}

=======
package demo;

import java.awt.image.BufferedImage;

import util.TopDownUtility;

import element.Block;
import element.Element;
import element.TopDownPlayField;

public class DemoBlock extends Block {

	public DemoBlock(TopDownPlayField playfield, BufferedImage image,
			int hardDegree) {
		super(playfield, image);
		this.hardDegree = hardDegree;
		destroyable = true;
	}

	public DemoBlock(TopDownPlayField playfield, BufferedImage image) {
		super(playfield, image);
		destroyable = false;
	}

	@Override
	public void init() {

//		this.setX(TopDownUtility.getRandom(0,
//				DemoGameEngine.WIDTH - this.getWidth()));
//		this.setY(TopDownUtility.getRandom(150, playfield.getBackground()
//				.getHeight() - DemoGameEngine.HEIGHT));
		playfield.getGroup("Block").add(this);
	}

	@Override
	public Element clone() {
		 DemoBlock DB=new DemoBlock(this.playfield, this.getImage(), this.hardDegree);
		 DB.init();// TODO Auto-generated method stub
		return DB;
	}

>>>>>>> ada42b2f157034c49af47fe8c2b0fb0d4d6625ad
}