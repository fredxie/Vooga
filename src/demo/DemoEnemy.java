package demo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import util.TopDownUtility;

import element.Bullet;
import element.Enemy;
import element.TopDownPlayField;
import game.Configuration;

public class DemoEnemy extends Enemy {

	public DemoEnemy(TopDownPlayField playfield, BufferedImage image, int HP) {
		super(playfield, image);
		healthPoint = HP;
		// TODO Auto-generated constructor stub
	}

	public DemoEnemy(BufferedImage image) {
		super(image);
	}

	@Override
	public void init() {

		this.setX(TopDownUtility.getRandom(0,
				DemoGameEngine.WIDTH - this.getWidth()));
		this.setY(TopDownUtility.getRandom(100, playfield.getBackground()
				.getHeight() - DemoGameEngine.HEIGHT));
	}

	@Override
	public void refresh(long elapsedTime) {
		if (show == false) { // enemy has not been shown
			if (getY() + getHeight() < playfield.getBackground().getY()
					+ DemoGameEngine.HEIGHT
					&& getY() > playfield.getBackground().getY()) {
				// show the enemy
				setVerticalSpeed(0.1);
				playfield.getGroup("Enemy").add(this);
				show = true;
				// enemy fires
				attack(elapsedTime);
			}
		} else { // for those have shown before, they should continue firing
			attack(elapsedTime);
		}
	}

	public void attack(long elapsedTime) {
		if (isActive()) {
			if (refireRate.action(elapsedTime)) {
				Bullet enemyMissile;
				try {
					enemyMissile = new Bullet(ImageIO.read(new File(
							"images/game/emissle_easy.png")), getX()
							+ getWidth() / 2, getY() + 20,
							Configuration.ENEMY_WEAPON_DAMAGE);
					enemyMissile.setVerticalSpeed(0.3);
					playfield.getGroup("Enemy Missile").add(enemyMissile);
					refireRate.refresh();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
