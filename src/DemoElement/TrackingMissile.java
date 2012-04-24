package DemoElement;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import DemoElement.Laser;
import demo.DemoGameEngine;
import element.Element;
import element.Enemy;
import element.Fighter;
import element.Weapon;

public class TrackingMissile extends Weapon {
	public Enemy target;
	double damage = 5;

	public TrackingMissile(BufferedImage image) {
		super(image);
		this.image = image;
	}

	public TrackingMissile(BufferedImage image, double x, double y) {
		super(image, x, y);
		this.image = image;
	}

	public TrackingMissile(BufferedImage image, double x, double y, int damage) {
		super(image, x, y);
		setDamage(damage);
		this.image = image;
	}

	public TrackingMissile(BufferedImage image, double x, double y,
			double eNEMY_WEAPON_DAMAGE) {
		super(image, x, y);
		this.damage = eNEMY_WEAPON_DAMAGE;
		this.image = image;
	}

	@Override
	public void genBullets(Fighter fighter, int numOfBullet, double weaponDamage) {

		Element[] element = playfield.getGroup("Enemy").getElement();
		int size = playfield.getGroup("Enemy").getSize();
		damage = weaponDamage;
		Random random = new Random();
		List<Enemy> potentialTarget = new ArrayList<Enemy>();
		for (int i = 0; i < size; i++) {
			if (element[i].isActive()
					&& element[i].getY() >= playfield.getTileBackground()
							.getY()
					&& element[i].getY() <= playfield.getTileBackground()
							.getY() + DemoGameEngine.HEIGHT) {
				potentialTarget.add((Enemy) element[i]);
			}
		}
		setTarget(potentialTarget.get(random.nextInt(potentialTarget.size())));

		Weapon[] laser = new Weapon[numOfBullet + 1];
		for (int i = 0; i < numOfBullet + 1; i++) {
			laser[i] = new Laser(image, fighter.getX() + fighter.getWidth()
					/ (numOfBullet + 2) * (i + 1), fighter.getY() - 50, damage);
			laser[i].setVerticalSpeed(-0.7);

		}
		addBullets(laser, fighter);

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	public void setTarget(Enemy target) {
		this.target = target;
	}

	@Override
	public void bulletUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public Element clone() {
		TrackingMissile TM = new TrackingMissile(this.getImage(), this.getX(),
				this.getY());// TODO Auto-generated method stub
		return TM;
	}
}
