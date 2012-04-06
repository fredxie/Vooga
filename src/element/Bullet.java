package element;
/**
 * 
 * @author ShiyuanWang
 */
import java.awt.image.BufferedImage;

public abstract class Bullet extends Element {

	private double damage = 1;
    
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
    public abstract Bullet[] genBullets(Fighter fighter, int numOfBullet);
	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
