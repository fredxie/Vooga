package element;

import game.Configuration;
import game.TopDownGame;
import game.TopDownGameObject;

import java.awt.image.BufferedImage;
import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.Timer;

public abstract class Fighter extends Element {
	
	private int healthPoint;
	private int lifeNum = Configuration.lifeNum;
	private int weaponDamage = Configuration.FIGHTER_WEAPON_DAMAGE;
	private int weaponStyle = 1;
	private double speedX, speedY;
	private double moveSpeed= 0.3;
	
	public boolean allowFire = true; 
	public Timer refireRate = new Timer(300); // allow to refire after 300 ms
	                                           // (default)	
	
	public TopDownGameObject game;
//	public Bullet bullet;
	public BufferedImage bulletImage;

	public Fighter(BufferedImage image) {
		super(image);
	}
	
	public void setPlayfield(TopDownPlayField playfield){
		this.playfield = playfield;
	}
	
	public void setGameObject(TopDownGameObject game){
		this.game = game;
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

	public void fighterControl(long elapsedTime) {
//		speedX = this.getHorizontalSpeed();
//		speedY = this.getVerticalSpeed();
		speedX = speedY =0;
		
		if (game.keyDown(Configuration.UP))
			speedY = -moveSpeed;
		else if (game.keyDown(Configuration.DOWN))
			speedY = moveSpeed;

		else if (game.keyDown(Configuration.LEFT))
			speedX = -moveSpeed;
		else if (game.keyDown(Configuration.RIGHT))
			speedX = moveSpeed;    
		
		if(!allowFire){
			allowFire = refireRate.action(elapsedTime);
		}
		
		else if(allowFire && game.keyDown(Configuration.FIRE))
			attack(elapsedTime, weaponStyle, weaponDamage);
		// stay relative motionless to the screen
		speedY -= Configuration.BACKGROUND_SPEED;
		setSpeed(speedX, speedY);
	}


	public void setRefireRate(int rate) {
		refireRate = new Timer(rate);
	}

	public void setBulletImage(BufferedImage bulletImage) {
		this.bulletImage = bulletImage;
	}
	
//	public abstract void fighterWeapon(long elapsedTime); //here developer should set their bullet style
//	public abstract void initFighter();
	public abstract void refresh(long elapsedTime);
	
	public void death(BufferedImage i){
		this.setImage(i);
	}
	
	public abstract void attack(long elapsedTime, int weaponStyle, int weaponDamage);
}
