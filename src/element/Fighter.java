package element;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Timer;

public abstract class Fighter extends Element {

	private final int UP = 0;
	private final int DOWN = 1;
	private final int LEFT = 2;
	private final int RIGHT = 3;

	private int healthPoint;
	private int lifeNum;
	private int weaponDamage;
	private int weaponStyle;
	private double speedX, speedY;
	private double moveSpeed;
	private boolean allowFire = false;
	private Timer refireRate = new Timer(300); // allow to refire after 300 ms
												// (default)
	private BufferedImage bulletImage;

	private double backgroundSpeed;

	public Fighter(BufferedImage image) {
		super(image);
	}

	public void setHP(int healthPoint) {
		this.healthPoint = healthPoint;
	}

	public int getHP() {
		return healthPoint;
	}

	public void setWeapon(int weaponDamage, int weaponStyle) {
		//change according to bonus
		this.weaponDamage = weaponDamage;
		this.weaponStyle = weaponStyle;
	}

	public void fighterControl(long elapsedTime, int key) {
		speedX = this.getHorizontalSpeed();
		speedY = this.getVerticalSpeed();
		switch (key) {
		case UP:
			speedY = -moveSpeed;
			break;
		case DOWN:
			speedY = moveSpeed;
			break;
		case LEFT:
			speedX = -moveSpeed;
			break;
		case RIGHT:
			speedX = moveSpeed;
			break;
		}

		// stay relative motionless to the screen
		speedY -= backgroundSpeed;
		setSpeed(speedX, speedY);
	}

	public void fire(long elapsedTime) {
		if (allowFire == false) {
			allowFire = refireRate.action(elapsedTime);
		}
		if (allowFire) {
			Bullet missile = new Bullet(bulletImage);
			//here we also need to add missile to playfield, haven't done yet 
			setBullet();
		}
	}

	public void setRefireRate(int rate) {
		refireRate = new Timer(rate);
	}
	
	public void setBackgroundSpeed(double backgroundSpeed) {
		this.backgroundSpeed = backgroundSpeed;
	}

	public void setBulletImage(BufferedImage bulletImage) {
		this.bulletImage = bulletImage;
	}
	
	public abstract void setBullet(); //here developer should set their bullet style
	
	public void death(BufferedImage i){
		this.setImage(i);
	}
}
