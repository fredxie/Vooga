package element;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.Sprite;

public abstract class Element extends Sprite {

	public TopDownPlayField playfield;

	public Element(BufferedImage image) {
		super(image);
	}

	public Element() {
		super();
	}

	public Element(BufferedImage image, double x, double y) {
		super(image, x, y);
	}

	public void setSpeed(double x, double y) {
		super.setSpeed(x, y);
	}

	public void setLocation(int x, int y) {
		super.setLocation(x, y);
	}

	public double getX() {
		return super.getX();
	}

	public double getY() {
		return super.getY();
	}

	public void setImage(BufferedImage image) {
		super.setImage(image);
	}

	public abstract void init();
	// public abstract void update(long elapsedTime);
}
