package element;

import java.awt.image.BufferedImage;

public class Bullet extends Element {

	private double damage;

	public Bullet(BufferedImage image) {
		super(image);
	}

	public Bullet(BufferedImage image, double x, double y) {
		super(image, x, y);
	}

	public Bullet(BufferedImage image, double x, double y, double eNEMY_WEAPON_DAMAGE) {
		super(image, x, y);
		this.damage = eNEMY_WEAPON_DAMAGE;
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double x) {
		this.damage = x;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
