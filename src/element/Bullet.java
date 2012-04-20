package element;
/**
 * 
 * @author ShiyuanWang
 */
import java.awt.image.BufferedImage;

public abstract class Bullet extends Element {
    double damage;
	BufferedImage image;
    
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
    public abstract  void genBullets(Fighter fighter, int numOfBullet, double weaponDamage);
 
    public void addBullets(Bullet[] bullets,Fighter fighter)
    {  
    	for(Bullet bullet : bullets)
			fighter.playfield.getGroup("Fighter Bullet").add(bullet);
		fighter.allowFire = false;
		
    }
	@Override
	public abstract void init();
}