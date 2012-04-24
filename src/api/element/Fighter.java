package api.element;


import java.awt.image.BufferedImage;

import demo.element.Laser;

import api.game.TopDownTimer;
import api.gameLevel.GameLevel;
import api.playerState.WeaponState;
import api.util.JsonUtil;
import api.util.TopDownImageUtil;


public abstract class Fighter extends Element {

	private static double FIGHTER_WEAPON_DAMAGE = 100;
	private static int INITIAL_STYLE = 0;
	// protected static double healthPoint = Configuration.FIGHTER_HP;
	protected static double healthPoint = JsonUtil.parse("paraConfig.json")
			.get("FIGHTER_HP");
	protected int lifeNum = JsonUtil.parse("paraConfig.json").get("lifeNum");
	protected double weaponDamage = FIGHTER_WEAPON_DAMAGE;
	protected int weaponStyle = INITIAL_STYLE;
	public boolean allowBomb = true;
	public TopDownTimer rebombRate = new TopDownTimer(5000); // allow to rebomb
	public boolean allowFire = false;
	public WeaponState weaponState = new WeaponState(this, weaponStyle,
			weaponDamage);
	public TopDownTimer refireRate = new TopDownTimer(1000); // allow to refire
	public double speedX, speedY; // after 300 ms
	public double backgroundSpeed = JsonUtil.parse("paraConfig.json").get(
			"BACKGROUND_SPEED");
	public GameLevel game;
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

	public void changeHP(double change) {
		healthPoint = healthPoint + change;
		if (healthPoint <= 0) {
			lifeNum--;
			healthPoint = JsonUtil.parse("paraConfig.json").get("FIGHTER_HP");
		}

	}

	public int getLifeNum() {
		return lifeNum;
	}

	public void setLifeNum(int lifeNum) {
		this.lifeNum = lifeNum;
	}

	public void changeLifeNum(int change) {
		lifeNum = lifeNum + change;
	}

	public void setRefireRate(int rate) {
		refireRate = new TopDownTimer(rate);
	}

	public void setBulletImage(BufferedImage bulletImage) {
		this.bulletImage = bulletImage;
	}

	public void death(BufferedImage i) {
		this.setImage(i);
	}

	// State Pattern of State Pattern about Bullet
	// Default Sate
	private Weapon bullet = new Laser(
			TopDownImageUtil.getImage("images/game/bigLaser1.png")); // Default
																		// Bullet

	public void setWeapon(int weaponDamage, int weaponStyle) {
		this.weaponDamage = weaponDamage;
		this.weaponStyle = weaponStyle;
	}

	public WeaponState getWeaponState() {
		return weaponState;
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

	public void setBombNum(int bombNum) {
		this.bombNum = bombNum;
	}

	public int getBombNum() {
		return bombNum;
	}

	public double getSpeedX() {
		return speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public abstract void attack();

	public void setGameObject(GameLevel game) {
		this.game = game;
	}
}