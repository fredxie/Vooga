package element;
/**
 * 
 * @author ShiyuanWang
 */
import game.Configuration;
import game.TopDownTimer;
import gameObject.TopDownGameObject;

import java.awt.image.BufferedImage;
import java.util.List;

import util.JsonUtil;
import configuration.GameParameters;

import keyconfiguration.Key;
import keyconfiguration.KeyAnnotation;

public abstract class RegularFighter extends Fighter {

	private static double healthPoint = Configuration.FIGHTER_HP;
	private int lifeNum = JsonUtil.parse("paraConfig.json").get(GameParameters.lifeNum);
	private double weaponDamage = Configuration.FIGHTER_WEAPON_DAMAGE;
	private int weaponStyle = Configuration.INITIAL_STYLE;
	private List<Key> keyList;
	public boolean allowBomb = true;
	private Satellite satellite;
	public TopDownTimer rebombRate = new TopDownTimer(5000); // allow to rebomb
																// after 5000 ms
																// (default)

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



	public RegularFighter(BufferedImage image) {
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

	public void setKeyList(List<Key> list) {
		keyList = list;
	}

	public void fighterControl(long elapsedTime) {
		//System.out.println(keyList.size());
		speedX = speedY = 0;
		for (Key key : keyList) {
			if (key.isKeyDown()) {
				key.notifyObserver(elapsedTime);
			}
		}
		speedY -= JsonUtil.parse("paraConfig.json").get(GameParameters.BACKGROUND_SPEED)/10.0;
		setSpeed(speedX, speedY);
	}

	@KeyAnnotation(action = "UP")
	public void keyUpPressed(long elapsedTime) {
		speedY = -moveSpeed;
	}

	@KeyAnnotation(action = "DOWN")
	public void keyDownPressed(long elapsedTime) {
		speedY = moveSpeed;
	}

	@KeyAnnotation(action = "LEFT")
	public void keyLeftPressed(long elapsedTime) {
		speedX = -moveSpeed;
	}

	@KeyAnnotation(action = "RIGHT")
	public void keyRightPressed(long elapsedTime) {
		speedX = moveSpeed;
	}

	@KeyAnnotation(action = "FIRE")
	public void keyFirePressed(long elapsedTime) {
		if (!allowFire) {
			allowFire = refireRate.action(elapsedTime);
		}

		else if (allowFire)
			attack(elapsedTime, weaponStyle, weaponDamage);
	}

	public void setRefireRate(int rate) {
		refireRate = new TopDownTimer(rate);
	}

	public void setBulletImage(BufferedImage bulletImage) {
		this.bulletImage = bulletImage;
	}

	public abstract void refresh(long elapsedTime);

	public void death(BufferedImage i) {
		this.setImage(i);
	}

	public double getWeaponDamage() {
		return weaponDamage;
	}

	public void setWeaponDamage(double d) {
		this.weaponDamage = d;
	}

	public abstract void bomb(long elapsedTime);

	public void setBombNum(int bombNum) {
		this.bombNum = bombNum;
	}

	public int getBombNum() {
		return bombNum;
	}
    public double getSpeedX()
    {
    	return speedX;
    }
    public double getSpeedY()
    {
    	return speedY;
    }

	public abstract void attack(long elapsedTime, int weaponStyle, double weaponDamage2);

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}


}