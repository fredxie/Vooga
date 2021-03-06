package demo.element;

import java.awt.image.BufferedImage;

import api.element.Block;
import api.element.Element;
import api.game.TopDownPlayField;

/**
 * 
 * @author Yi Ding
 *
 */
@SuppressWarnings("serial")
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

		// this.setX(TopDownUtility.getRandom(0,
		// DemoGameEngine.WIDTH - this.getWidth()));
		// this.setY(TopDownUtility.getRandom(150, playfield.getBackground()
		// .getHeight() - DemoGameEngine.HEIGHT));
		playfield.getGroup("Block").add(this);
	}

	@Override
	public Element clone() {
		DemoBlock DB = new DemoBlock(this.playfield, this.getImage(),
				this.hardDegree);
		DB.init();// TODO Auto-generated method stub
		return DB;
	}

}