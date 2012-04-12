package element;

/**
 * 
 * @author ShiyuanWang
 */
import java.awt.image.BufferedImage;

public class Missile extends Bullet {
	double damage = 3;

	public Missile(BufferedImage image) {
		super(image);
		this.image = image;
	}

	public Missile(BufferedImage image, double x, double y) {
		super(image, x, y);
		this.image = image;
	}

	public Missile(BufferedImage image, double x, double y, int damage) {
		super(image, x, y);
		setDamage(damage);
		this.image = image;
	}

	public Missile(BufferedImage image, double x, double y,
			double eNEMY_WEAPON_DAMAGE) {
		super(image, x, y);
		this.damage = eNEMY_WEAPON_DAMAGE;
		this.image = image;
	}

	@Override
	public void genBullets(Fighter fighter, int numOfBullet, double weaponDamage) {
	    damage = weaponDamage;
		Bullet[] missile = new Bullet[numOfBullet * 2 + 1];
		switch (numOfBullet) {
		case 0: {

			missile[0] = new Missile(image, fighter.getX() + fighter.getWidth()
					/ 2, fighter.getY() - 20, damage);
			missile[0].setVerticalSpeed(-0.7);
			break;
		}
		case 1: {
			for (int i = 0; i < 3; i++) {
				missile[i] = new Missile(image, fighter.getX()
						+ fighter.getWidth() / 2, fighter.getY() - 20, damage);
				missile[i].setSpeed(0.35 * Math.sin((1 - i) * 30 * 3.14 / 180),
						-0.6 * Math.cos((1 - i) * 30 * 3.14 / 180));
			}
			break;
		}
		case 2: {
			for (int i = 0; i < 5; i++) {
				missile[i] = new Missile(image, fighter.getX()
						+ fighter.getWidth() / 2, fighter.getY() - 20, damage);
				missile[i].setSpeed(
						0.35 * Math.sin((2 - i) * 22.5 * 3.14 / 180), -0.6
								* Math.cos((2 - i) * 22.5 * 3.14 / 180));
			}
			break;
		}
		}
		
	    addBullets(missile,fighter);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}