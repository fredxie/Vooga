package element;
/**
 * 
 * @author ShiyuanWang
 */
import game.Configuration;
import game.TopDownGameObject;

import java.awt.image.BufferedImage;

import util.TopDownImageUtil;

import demo.DemoGameEngine;

public abstract class Satellite extends Fighter{


	protected Bullet bullet = new Laser(TopDownImageUtil.getImage("images/game/beam3.png"));
	RegularFighter master;
	TopDownGameObject game;
	double speedX;
	double speedY;
	public boolean allowFire = true; 

	public Satellite(BufferedImage image) {
		super(image);
	}

	public Satellite(BufferedImage image, RegularFighter fighter) {
		super(image);
		master = fighter;
		init();
	}



	public void setWeapon(Bullet bullet,int weaponDamage, int numOfBullet) {
		this.bullet = bullet;
	}


	public void init()
	{  
		playfield = master.playfield;
		game = master.game;
		setLocation(master.getX(), master.getY());
	}

	public void fighterControl(long elapsedTime) {
		if(isActive())
		{
			if(!allowFire){
			allowFire = refireRate.action(elapsedTime);
		}

		else 
			attack(elapsedTime, 0, height);
		speedY =0.6*master.getSpeedY()- Configuration.BACKGROUND_SPEED * 0.4;
		speedX = 0.6 * master.getSpeedX();
		setSpeed(speedX, speedY);}
	}

	public void attack(long elapsedTime, int weaponStyle, double weaponDamage) {
        Bullet[] bullets = bullet.genBullets(this,weaponStyle);
		for(Bullet bullet : bullets)
		playfield.getGroup("Fighter Bullet").add(bullet);
		allowFire = false;
	}
}