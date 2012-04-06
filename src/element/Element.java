package element;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.Sprite;

public abstract class Element extends Sprite {

	public TopDownPlayField playfield;

	
	 private int mass;   // this is Yi Ding's revise

		public int getMass() {    // this is Yi Ding's revise
			return mass;
		}

		public void setMass(int mass) {   // this is Yi Ding's revise
			this.mass = mass;
		}
	
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
