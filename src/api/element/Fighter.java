package api.element;

import java.awt.image.BufferedImage;

import api.game.TopDownTimer;
import api.gameLevel.GameLevel;
import api.playerState.PlayerStateManager;
import api.playerState.WeaponState;
import api.util.JsonUtil;

/**
 * This abstract class keep the basic feature of the fighter which is ready to
 * be extended.
 */

@SuppressWarnings("serial")
public abstract class Fighter extends Element {

	private static double FIGHTER_WEAPON_DAMAGE = 100;
	private static int INITIAL_STYLE = 0;
	protected static double healthPoint = JsonUtil
			.parse("json/paraConfig.json").get("FIGHTER_HP");
	protected int lifeNum = JsonUtil.parse("json/paraConfig.json").get(
			"lifeNum");
	protected double weaponDamage = FIGHTER_WEAPON_DAMAGE;
	protected int weaponStyle = INITIAL_STYLE;
	public boolean allowBomb = true;
	public TopDownTimer rebombRate = new TopDownTimer(5000);
	public boolean allowFire = false;
	public TopDownTimer refireRate = new TopDownTimer(1000);
	public double speedX, speedY;
	public double backgroundSpeed = JsonUtil.parse("json/paraConfig.json").get(
			"BACKGROUND_SPEED");
	public GameLevel game;
	public BufferedImage bulletImage;
	public int bombNum;
	protected PlayerStateManager stateManager;

	public Fighter(BufferedImage image) {
		super(image);
	}

	public void setPlayfield(TopDownPlayField playfield) {
		this.playfield = playfield;
	}

	@SuppressWarnings("static-access")
	public void setHP(double fIGHTER_HP) {

		this.healthPoint = fIGHTER_HP;
	}

	public static double getHP() {
		return healthPoint;
	}

	/**
	 * Change the HP of the Fighter
	 */

	public void changeHP(double change) {
		healthPoint = healthPoint + change;
		if (healthPoint <= 0) {
			lifeNum--;
			healthPoint = JsonUtil.parse("json/paraConfig.json").get(
					"FIGHTER_HP");
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

	public void setWeapon(int weaponDamage, int weaponStyle) {
		this.weaponDamage = weaponDamage;
		this.weaponStyle = weaponStyle;
	}

	public WeaponState getWeaponState() {
		return stateManager.getWeaponState();
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

	/**
	 * Return the state manager which manages all states of the fighter
	 */

	public PlayerStateManager getStateManager() {
		return stateManager;
	}

	public void setGameObject(GameLevel game) {
		this.game = game;
	}
}