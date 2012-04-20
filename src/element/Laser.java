package element;

/**
 * 
 * @author ShiyuanWang
 */
import java.awt.image.BufferedImage;

public class Laser extends Bullet {
	
	double damage = 5;

	public Laser(BufferedImage image) {
		super(image);
		this.image = image;
	}

	public Laser(BufferedImage image, double x, double y) {
		super(image, x, y);
		this.image = image;
	}

	public Laser(BufferedImage image, double x, double y, double damage) {
		super(image, x, y);
		setDamage(damage);
		this.image = image;
	}

	@Override
	public  void genBullets(Fighter fighter, int numOfBullet, double weaponDamage) {
		damage = weaponDamage;
		Bullet[] laser = new Bullet[numOfBullet + 1];
		for (int i = 0; i < numOfBullet + 1; i++) {
			laser[i] = new Laser(image, fighter.getX() + fighter.getWidth()
					/ (numOfBullet + 2) * (i + 1), fighter.getY() - 50, damage);
			laser[i].setVerticalSpeed(-0.7);

		}
		addBullets(laser,fighter);
     
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public Element clone() {
		// TODO Auto-generated method stub
		return new Laser(this.image, this.getX(), this.getY());
	}

}