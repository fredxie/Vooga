package element;

import game.Configuration;
import game.TopDownTimer;
import gameObject.GameLevel;

import java.awt.image.BufferedImage;
import java.util.List;

import configuration.GameParameters;

import demo.DemoSatellite;

import util.JsonUtil;
import util.TopDownImageUtil;

import keyconfiguration.Key;

public abstract class Fighter extends Element {

	private static double healthPoint = Configuration.FIGHTER_HP;
	private int lifeNum = JsonUtil.parse("paraConfig.json").get(GameParameters.lifeNum);
	private double weaponDamage = Configuration.FIGHTER_WEAPON_DAMAGE;
	private int weaponStyle = Configuration.INITIAL_STYLE;
	public boolean allowBomb = true;
	public TopDownTimer rebombRate = new TopDownTimer(5000); // allow to rebomb
	public boolean allowFire = false;
	public TopDownTimer refireRate = new TopDownTimer(1000); // allow to refire
    public double speedX,speedY;												// after 300 ms

	public GameLevel game;
	// public Bullet bullet;
	public BufferedImage bulletImage;
	public int bombNum;

	public Fighter(BufferedImage image) {
		super(image);
	}

	public void setPlayfield(TopDownPlayField playfield) {
		this.playfield = playfield;
	}


	public void setHP(double fIGHTER_HP) {

		this.healthPoint = fIGHTER_HP;
	}

	public static double getHP() {
		return healthPoint;
	}

	public int getLifeNum() {
		return lifeNum;
	}

	public void setLifeNum(int lifeNum) {
		this.lifeNum = lifeNum;
	}

	public void setRefireRate(int rate) {
		refireRate = new TopDownTimer(rate);
	}

	public void setBulletImage(BufferedImage bulletImage) {
		this.bulletImage = bulletImage;
	}

	// public abstract void fighterWeapon(long elapsedTime); //here developer
	// should set their bullet style
	// public abstract void initFighter();

	public void death(BufferedImage i) {
		this.setImage(i);
	}

	// State Pattern of State Pattern about Bullet
	 //Default Sate
	private Bullet bullet = new Laser(
			TopDownImageUtil.getImage("images/game/bigLaser1.png")); // Default Bullet  

	public void setWeapon(int weaponDamage, int weaponStyle) {
		this.weaponDamage = weaponDamage;
		this.weaponStyle = weaponStyle;
	}

	public int getWeaponStyle() {
		return weaponStyle;
	}

	public void setWeaponStyle(int weaponStyle) {
		this.weaponStyle = weaponStyle;
	}

	public double getWeaponDamage() {
		return weaponDamage;
	}

	public void setWeaponDamage(double d) {
		this.weaponDamage = d;
	}

	public void setBulletState(Bullet bullet) {
		this.bullet = bullet;
	}
    public void attack(long elapsedTime, int numOfBullet, double weaponDamage) {
		
    	bullet.genBullets(this, numOfBullet, weaponDamage);
	}
    

	public double getSpeedX() {
		return speedX;
	}

	public double getSpeedY() {
		return speedY;
	}
	
	
	public void setGameObject(GameLevel game) {
		this.game = game;
	}
}