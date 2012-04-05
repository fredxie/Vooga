package element;

import java.awt.image.BufferedImage;

public class Bullet extends Element {

	private int damage;

	public Bullet(BufferedImage image) {
		super(image);
	}

	public Bullet(BufferedImage image, double x, double y) {
		super(image, x, y);
	}

	public Bullet(BufferedImage image, double x, double y, int damage) {
		super(image, x, y);
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
