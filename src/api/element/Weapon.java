package api.element;

/**
 * 
 * @author ShiyuanWang
 */
import java.awt.image.BufferedImage;

public abstract class Weapon extends Element {
	double damage=1;
	protected BufferedImage image;
	protected double bulletSpeed = -0.7;
	Weapon[] bullets;

	public Weapon(BufferedImage image) {
		super(image);
	}

	public Weapon(BufferedImage image, double x, double y) {
		super(image, x, y);
	}

	public Weapon(BufferedImage image, double x, double y,
			double eNEMY_WEAPON_DAMAGE) {
		super(image, x, y);
		this.damage = eNEMY_WEAPON_DAMAGE;
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double x) {
		this.damage = x;
	}

	public abstract void genBullets(Fighter fighter, int numOfBullet,
			double weaponDamage);

	public void addBullets(Weapon[] bullets, Fighter fighter) {
		this.bullets = bullets;
		for (Weapon bullet : bullets)
			fighter.playfield.getGroup("Fighter Bullet").add(bullet);
		fighter.allowFire = false;

	}

	@Override
	public abstract void init();

	public abstract void bulletUpdate();

	public void setBulletSpeed(double bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
	}

	public double getBulletSpeed() {
		return bulletSpeed;
	}
}