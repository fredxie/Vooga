package demo;

import java.awt.image.BufferedImage;

import util.TopDownAreaUtil;
import util.TopDownImageUtil;

import element.Bullet;
import element.Element;
import element.Fighter;
import game.Configuration;
import game.TopDownVolatileElement;

public class DemoFighter extends Fighter {

	public DemoFighter(BufferedImage image) {
		super(image);
	}

	public void init() {

		setRefireRate(100);// Default Re-fire Rate
		setLocation(DemoGameEngine.WIDTH / 2, playfield.getBackground()
				.getHeight() - getHeight());// Default Location
		playfield.getGroup("Fighter").add(this);
		setBombNum(Configuration.BOMB_NUM);
	}

	public void refresh(long elapsedTime) {
		if (isActive()) {
			fighterControl(elapsedTime);
			TopDownAreaUtil.setFighterArea(this, playfield.getTileBackground(),
					DemoGameEngine.HEIGHT, DemoGameEngine.WIDTH);
			if (getY() == 0) {
				game.finish();
			}
		}
	}

	@Override
	public void attack(long elapsedTime, int weaponStyle, int weaponDamage) {

		switch (weaponStyle) {
		case 0: {
			Bullet missile = new Bullet(
					TopDownImageUtil.getImage("images/game/bullet.png"),
					this.getX() + this.getWidth() / 2, this.getY() - 20,
					weaponDamage);
			missile.setVerticalSpeed(-0.7);
			playfield.getGroup("Fighter Bullet").add(missile);
			break;
		}
		case 1: {
			Bullet[] missile = new Bullet[3];
			for (int i = 0; i < 3; i++) {
				missile[i] = new Bullet(
						TopDownImageUtil.getImage("images/game/bullet.png"),
						this.getX() + this.getWidth() / 2, this.getY() - 20,
						weaponDamage);
				missile[i].setSpeed(0.35 * Math.sin((1 - i) * 30 * 3.14 / 180),
						-0.6 * Math.cos((1 - i) * 30 * 3.14 / 180));
				playfield.getGroup("Fighter Bullet").add(missile[i]);
			}
			break;
		}
		case 2: {
			Bullet[] missile = new Bullet[5];
			for (int i = 0; i < 5; i++) {
				missile[i] = new Bullet(
						TopDownImageUtil.getImage("images/game/bullet.png"),
						this.getX() + this.getWidth() / 2, this.getY() - 20,
						weaponDamage);
				missile[i].setSpeed(
						0.35 * Math.sin((2 - i) * 22.5 * 3.14 / 180), -0.6
								* Math.cos((2 - i) * 22.5 * 3.14 / 180));
				playfield.getGroup("Fighter Bullet").add(missile[i]);
			}
			break;
		}
		}
		allowFire = false;
		// refireRate.refresh();
	}

	public void bomb(long elapsedTime) {
		if (allowBomb == false) {
			allowBomb = rebombRate.action(elapsedTime);
		}
		if (game.keyDown(Configuration.BOMB) && bombNum > 0 && allowBomb) {
			bombNum--;
			clearElement("Enemy");
			clearElement("Enemy Missile");
			allowBomb = false;
			// rebombRate.refresh();
		}

	}

	private void clearElement(String name) {
		Element[] element = playfield.getGroup(name).getElement();
		int size = playfield.getGroup(name).getSize();
		for (int i = 0; i < size; i++) {
			if (element[i].isActive()
					&& element[i].getY() >= playfield.getTileBackground()
							.getY()
					&& element[i].getY() <= playfield.getTileBackground()
							.getY() + DemoGameEngine.HEIGHT) {
				element[i].setActive(false);
				if (name.equals("Enemy")) {
					playfield.add(new TopDownVolatileElement(TopDownImageUtil
							.getImages("images/game/explosion.png", 6, 1),
							element[i].getX(), element[i].getY()));
					// EnemyDestroyedCollision.destroyed++;
				}
			}
		}
	}

}
