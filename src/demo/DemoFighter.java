package demo;

import java.awt.image.BufferedImage;

import DemoPlayerState.NormalCollisionState;


import util.TopDownAreaUtil;
import util.TopDownImageUtil;
import element.Element;
import element.Laser;
import element.PhysicalProtection;
import element.RegularFighter;
import element.Satellite;
import element.Weapon;
import game.TopDownVolatileElement;

public class DemoFighter extends RegularFighter {
	private int BOMB_NUM = 5;
	Weapon bullet = new Laser(  
			TopDownImageUtil.getImage("images/game/bigLaser1.png"));
	private Satellite satellite;
	private DemoProtection protection;
    public static boolean best_weapon = false;
	public DemoFighter(BufferedImage image) {
		super(image);
	}
	
	public void initHelper() {
		setRefireRate(100);// Default Re-fire Rate
		setLocation(DemoGameEngine.WIDTH / 2, playfield.getBackground()
				.getHeight() - getHeight());// Default Location
		playfield.getGroup("Fighter").add(this);
		setBombNum(BOMB_NUM);
		collisionState.changeState(new NormalCollisionState(collisionState));
		stateList.add(weaponState);
		stateList.add(assistanceState);
		stateList.add(collisionState);
		setMass(4);

	}

	public void refresh(long elapsedTime) {

		if (isActive()) {
			stateUpdate(elapsedTime);
		
			if(this.getWeaponStyle() == 3){ 
				best_weapon = true;
			}
			else {
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
	
	public void keyUpPressed(long elapsedTime) {
		// TODO Auto-generated method stub
		// speedY = -moveSpeed;
		setVerticalSpeed(-moveSpeed);
	}
	
	public void keyDownPressed(long elapsedTime) {
		// speedY = moveSpeed;
		setVerticalSpeed(moveSpeed);
	}

	public void keyLeftPressed(long elapsedTime) {
		// speedX = -moveSpeed;
		setHorizontalSpeed(-moveSpeed);
	}

	public void keyRightPressed(long elapsedTime) {
		// speedX = moveSpeed;
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
		// TODO Auto-generated method stub
		return new DemoFighter(this.getImage());
	}

	@Override
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