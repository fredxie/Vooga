package element;

import game.Configuration;
import game.TopDownGame;
import game.TopDownGameObject;
import game.TopDownTimer;

import java.awt.image.BufferedImage;
import java.util.List;

import keyconfiguration.Key;
import keyconfiguration.KeyAnnotation;

import com.golden.gamedev.object.PlayField;

public abstract class Fighter extends Element {

	private int healthPoint = Configuration.FIGHTER_HP;
	private int lifeNum = Configuration.lifeNum;
	private int weaponDamage = Configuration.FIGHTER_WEAPON_DAMAGE;

	private int weaponStyle = Configuration.INITIAL_STYLE;
	private List<Key> keyList;

	public boolean allowBomb = true;
	public TopDownTimer rebombRate = new TopDownTimer(5000); // allow to rebomb
																// after 5000 ms
																// (default)

	public int bombNum;

	public int getWeaponStyle() {
		return weaponStyle;
	}

	public void setWeaponStyle(int weaponStyle) {
		this.weaponStyle = weaponStyle;
	}

	private double speedX, speedY;
	private double moveSpeed = 0.3;

	public boolean allowFire = true;
	public TopDownTimer refireRate = new TopDownTimer(300); // allow to refire
															// after 300 ms
	// (default)

	public TopDownGameObject game;
	// public Bullet bullet;
	public BufferedImage bulletImage;

	public Fighter(BufferedImage image) {
		super(image);
	}

	public void setPlayfield(TopDownPlayField playfield) {
		this.playfield = playfield;
	}

	public void setGameObject(TopDownGameObject game) {
		this.game = game;
	}

	public void setHP(int healthPoint) {

		this.healthPoint = healthPoint;
	}

	public int getHP() {
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

	public void setKeyList(List<Key> list) {
		keyList = list;
	}

	public void fighterControl(long elapsedTime) {
		speedX = speedY = 0;
		for (Key key : keyList) {
			if (key.isKeyDown()) {
				key.notifyObserver(elapsedTime);
			}
		}
		speedY -= Configuration.BACKGROUND_SPEED;
		setSpeed(speedX, speedY);
	}

	@KeyAnnotation(action = "up")
	public void keyUpPressed(long elapsedTime) {
		speedY = -moveSpeed;
	}

	@KeyAnnotation(action = "down")
	public void keyDownPressed(long elapsedTime) {
		speedY = moveSpeed;
	}

	@KeyAnnotation(action = "left")
	public void keyLeftPressed(long elapsedTime) {
		speedX = -moveSpeed;
	}

	@KeyAnnotation(action = "right")
	public void keyRightPressed(long elapsedTime) {
		speedX = moveSpeed;
	}

	@KeyAnnotation(action = "attack")
	public void keyFirePressed(long elapsedTime) {
		if (!allowFire) {
			allowFire = refireRate.action(elapsedTime);
		}

		else if (allowFire && game.keyDown(Configuration.FIRE))
			attack(elapsedTime, weaponStyle, weaponDamage);
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
	public abstract void refresh(long elapsedTime);

	public void death(BufferedImage i) {
		this.setImage(i);
	}

	public int getWeaponDamage() {
		return weaponDamage;
	}

	public void setWeaponDamage(int weaponDamage) {
		this.weaponDamage = weaponDamage;
	}

	public abstract void bomb(long elapsedTime);

	public void setBombNum(int bombNum) {
		this.bombNum = bombNum;
	}

	public int getBombNum() {
		return bombNum;
	}

	public abstract void attack(long elapsedTime, int weaponStyle,
			int weaponDamage);
}
