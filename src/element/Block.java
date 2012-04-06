package element;

import java.awt.image.BufferedImage;

public abstract class Block extends Element {

	protected int hardDegree;

	protected boolean destroyable;

	public Block(BufferedImage image) {
		super(image);
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

	public void setHardDegree(int hardDegree) {
		this.hardDegree = hardDegree;
	}

	public Block(TopDownPlayField playfield, BufferedImage image) {
		super(image);
		this.playfield = playfield;
	}

	@Override
	public abstract void init();
}

