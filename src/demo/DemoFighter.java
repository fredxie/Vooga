package demo;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import configuration.api.KeyAnnotation;

import playerState.AssistanceState;
import playerState.CollisionState;
import util.JsonUtil;
import util.TopDownAreaUtil;
import util.TopDownImageUtil;
import DemoElement.Laser;
import DemoPlayerState.NormalCollisionStatus;
import element.Element;
import element.RegularFighter;
import element.Weapon;
import game.TopDownTimer;
import game.TopDownVolatileElement;

public class DemoFighter extends RegularFighter {
	private int BOMB_NUM = 5;
	Weapon bullet = new Laser(
			TopDownImageUtil.getImage("images/game/bigLaser1.png"));
	private DemoSatellite satellite;
	private DemoProtection protection;
	public static boolean best_weapon = false;

	public DemoFighter(BufferedImage image) {
		super(image);
	}

	public void initHelper() {
		moveSpeed = 0.3;
		rebombRate = new TopDownTimer(5000);
		assistanceState = new AssistanceState(this);
		collisionState = new CollisionState(this);
		setRefireRate(100);// Default Re-fire Rate
		setLocation(DemoGameEngine.WIDTH / 2, playfield.getBackground()
				.getHeight() - getHeight());// Default Location
		playfield.getGroup("Fighter").add(this);
		setBombNum(BOMB_NUM);
		collisionState.changeState(new NormalCollisionStatus(collisionState));
		stateList.add(weaponState);
		stateList.add(assistanceState);
		stateList.add(collisionState);
		setMass(4);
		JsonUtil.registerKeyAcion("BOMB", KeyEvent.VK_CONTROL);
	}

	public void refresh(long elapsedTime) {

		if (isActive()) {
			stateUpdate(elapsedTime);

			if (this.getWeaponStyle() == 3) {
				best_weapon = true;
			} else {
				best_weapon = false;
			}
			TopDownAreaUtil.setFighterArea(this, playfield.getTileBackground(),
					DemoGameEngine.HEIGHT, DemoGameEngine.WIDTH);
			if (getY() == 0) {
				game.finish();
			}
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
				}
			}
		}
	}

	public void genSatellite(BufferedImage image) {
		satellite = new DemoSatellite(image, this);

	}

	public DemoSatellite getSatellite() {
		return satellite;
	}

	public void genProtection(BufferedImage image) {
		protection = new DemoProtection(image, this);

	}

	public DemoProtection getProtection() {
		return protection;
	}

	public void keyUpPressed(long elapsedTime) {
		setVerticalSpeed(-moveSpeed);
	}

	public void keyDownPressed(long elapsedTime) {
		setVerticalSpeed(moveSpeed);
	}

	public void keyLeftPressed(long elapsedTime) {
		setHorizontalSpeed(-moveSpeed);
	}

	public void keyRightPressed(long elapsedTime) {
		setHorizontalSpeed(moveSpeed);
	}

	public void keyFirePressed(long elapsedTime) {
		if (!allowFire) {
			allowFire = refireRate.action(elapsedTime);
		}

		else if (allowFire)
			attack();
	}

	@Override
	public Element clone() {
		return new DemoFighter(this.getImage());
	}

	@KeyAnnotation(action = "BOMB")
	public void keyBombPressed(long elapsedTime) {
		if (allowBomb == false) {
			allowBomb = rebombRate.action(elapsedTime);
		}
		if (bombNum > 0 && allowBomb) {
			bombNum--;
			clearElement("Enemy");
			clearElement("Enemy Missile");
			allowBomb = false;
		}
	}

}