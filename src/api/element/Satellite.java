package api.element;

/**
 * 
 * @author ShiyuanWang
 */
import java.awt.image.BufferedImage;

import api.util.JsonUtil;
import api.util.TopDownAreaUtil;
import api.util.TopDownImageUtil;

import demo.game.DemoGameEngine;

public abstract class Satellite extends AutoFighter {
	protected Weapon bullet = new Laser(
			TopDownImageUtil.getImage("images/game/beam3.png"));

	public Satellite(BufferedImage image) {
		super(image);
	}

	public Satellite(BufferedImage image, RegularFighter fighter) {
		super(image);
		master = fighter;
		init();
	}

	public void setWeapon(Weapon bullet, int weaponDamage, int numOfBullet) {
		this.bullet = bullet;
	}

	public void init() {
		playfield = master.playfield;
		game = master.game;
		weaponState.changeState(bullet);
		weaponState.setWeapon(0, 1);
		setRefireRate(1000);
		setLocation(master.getX() - 0.5 * master.getWidth(), master.getY());
	}

	public void fighterControl(long elapsedTime) {
		speedY = 0;
		speedX = 0;
		if (master.isActive()) {
			if (!allowFire) {
				allowFire = refireRate.action(elapsedTime);
			} else
				attack();
			speedY = master.getVerticalSpeed() * 0.5;
			speedX = 0.3 * master.getHorizontalSpeed();
			setSpeed(speedX, speedY);
			TopDownAreaUtil.setFighterArea(this, playfield.getTileBackground(),
					DemoGameEngine.HEIGHT, DemoGameEngine.WIDTH);
		} else
			setActive(false);
	}

	public void setBrinkVerticalSpeed() {
		setVerticalSpeed(-JsonUtil.parse("json/paraConfig.json").get(
				"BACKGROUND_SPEED"));
	}

	public void setBrinkHorizontalSpeed() {
		setHorizontalSpeed(0);
	}

	public void attack() {

		weaponState.fire();
		allowFire = false;
	}

}