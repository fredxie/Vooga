package api.element;

import java.awt.image.BufferedImage;

import api.game.TopDownPlayField;

/**
 * This class defines Block Sprite to help developer use blocks.
 * 
 * @author Yi Ding
 *
 */

@SuppressWarnings("serial")
public abstract class Block extends Element {

	protected int hardDegree;

	protected boolean destroyable;

	public Block(BufferedImage image) {
		super(image);
	}

	public Block(TopDownPlayField playfield, BufferedImage image) {
		super(image);
		this.playfield = playfield;
	}

	public boolean show = false;

	public int getHardDegree() {
		return hardDegree;
	}

	public boolean isDestroyable() {
		return destroyable;
	}

	public void setDestroyable(boolean destroyable) {
		this.destroyable = destroyable;
	}

	public void changeHardDegree(int hardDegree) {
		this.hardDegree = hardDegree;
	}

	public void decreaseHardDegree() {
		hardDegree = hardDegree - 1;
	}

	@Override
	public abstract void init();
}
