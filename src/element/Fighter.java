package element;

import game.Configuration;
import game.TopDownGame;
import gameObject.TopDownGameObject;
import game.TopDownTimer;

import java.awt.image.BufferedImage;
import java.util.List;

import util.JsonUtil;


import configuration.GameParameters;

public abstract class Fighter extends Element {

	private static double healthPoint = Configuration.FIGHTER_HP;
	private int lifeNum = JsonUtil.parse("paraConfig.json").get(GameParameters.lifeNum);
	private double weaponDamage = Configuration.FIGHTER_WEAPON_DAMAGE;
	private int weaponStyle = Configuration.INITIAL_STYLE;
	public boolean allowBomb = true;
	public TopDownTimer rebombRate = new TopDownTimer(5000); // allow to rebomb
																// after 5000 ms
																// (default)
	public double speedX, speedY;
	public double moveSpeed = 0.3;

	public boolean allowFire = true;
	public TopDownTimer refireRate = new TopDownTimer(300); // allow to refire
															// after 300 ms
	// (default)

	public TopDownGameObject game;
	// public Bullet bullet;
	public BufferedImage bulletImage;
	public int bombNum;

	public int getWeaponStyle() {
		return weaponStyle;
	}

	public void setWeaponStyle(int weaponStyle) {
		this.weaponStyle = weaponStyle;
	}



	public Fighter(BufferedImage image) {
		super(image);
	}

	public void setPlayfield(TopDownPlayField playfield) {
		this.playfield = playfield;
	}

	public void setGameObject(TopDownGameObject game) {
		this.game = game;
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

	public void setWeapon(int weaponDamage, int weaponStyle) {
		// change according to bonus
		this.weaponDamage = weaponDamage;
		this.weaponStyle = weaponStyle;
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

	public double getWeaponDamage() {
		return weaponDamage;
	}

	public void setWeaponDamage(double d) {
		this.weaponDamage = d;
	}


	public abstract void attack(long elapsedTime, int weaponStyle, double weaponDamage2);
}