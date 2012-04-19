package demo;

import java.awt.image.BufferedImage;

import configuration.GameParameters;

import util.JsonUtil;
import util.TopDownAreaUtil;
import util.TopDownImageUtil;

import element.Bullet;
import element.Element;
import element.Fighter;
import element.Laser;
import element.Missile;
import element.PhysicalProtection;
import element.RegularFighter;
import element.Satellite;
import element.Weapon;
import game.Configuration;
import game.TopDownVolatileElement;

public class DemoFighter extends RegularFighter {
	Weapon bullet = new Laser(
			TopDownImageUtil.getImage("images/game/bigLaser1.png"));
	private Satellite satellite;
	private DemoProtection protection;

	public DemoFighter(BufferedImage image) {
		super(image);
	}
	
	public void initHelper() {
		setRefireRate(100);// Default Re-fire Rate
		setLocation(DemoGameEngine.WIDTH / 2, playfield.getBackground()
				.getHeight() - getHeight());// Default Location
		playfield.getGroup("Fighter").add(this);
		setBombNum(Configuration.BOMB_NUM);
		stateList.add(weaponState);
		stateList.add(assistanceState);
		stateList.add(collisionState);
		setMass(4);

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
	public void attack(long elapsedTime, int weaponStyle, double weaponDamage) {
		bullet.genBullets(this, weaponStyle, weaponDamage);
		allowFire = false;
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

	public void genSatellite(BufferedImage image) {
		satellite = new DemoSatellite(image, this);

	}

	public Satellite getSatellite() {
		return satellite;
	}

	public void genProtection(BufferedImage image) {
		protection = new DemoProtection(image, this);

	}

	public PhysicalProtection getProtection() {
		return protection;
	}
	
//	@KeyAnnotation(action = GameParameters.UP)
	public void keyUpPressed(long elapsedTime) {
		// TODO Auto-generated method stub
		// speedY = -moveSpeed;
		setVerticalSpeed(-moveSpeed);
	}
	
//	@KeyAnnotation(action = GameParameters.DOWN)
	public void keyDownPressed(long elapsedTime) {
		// speedY = moveSpeed;
		setVerticalSpeed(moveSpeed);
	}

//	@KeyAnnotation(action = GameParameters.LEFT)
	public void keyLeftPressed(long elapsedTime) {
		// speedX = -moveSpeed;
		setHorizontalSpeed(-moveSpeed);
	}

//	@KeyAnnotation(action = GameParameters.RIGHT)
	public void keyRightPressed(long elapsedTime) {
		// speedX = moveSpeed;
		setHorizontalSpeed(moveSpeed);
	}

//	@KeyAnnotation(action = GameParameters.FIRE)
	public void keyFirePressed(long elapsedTime) {
		if (!allowFire) {
			allowFire = refireRate.action(elapsedTime);
		}

		else if (allowFire)
			attack(elapsedTime, weaponStyle, weaponDamage);
	}
}