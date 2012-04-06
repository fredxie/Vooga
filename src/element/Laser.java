package element;
/**
 * 
 * @author ShiyuanWang
 */
import java.awt.image.BufferedImage;

public class Laser extends Bullet{
    int damage = 5;
    BufferedImage image; 
	public Laser(BufferedImage image) {
		super(image);
		this.image = image;
	}

	public Laser(BufferedImage image, double x, double y) {
		super(image, x, y);
		this.image = image;
	}

	public Laser(BufferedImage image, double x, double y, int damage) {
		super(image, x, y);
		setDamage(damage);
		this.image = image;
	}
	@Override
	public Bullet[] genBullets(Fighter fighter, int numOfBullet) {
		Bullet[] laser = new Bullet[numOfBullet+1];
		for(int i = 0;i<numOfBullet+1;i++)
		{
			laser[i] = new Laser(image, fighter.getX()+fighter.getWidth()/(numOfBullet+2)*(i+1),fighter.getY() - 50,damage);
			laser[i].setVerticalSpeed(-0.7);
			
		}
		return laser;
	}

}
