package api.playerState;

import demo.element.Missile;
import api.element.Fighter;
import api.element.Weapon;
import api.util.TopDownImageUtil;

/**
 * This class keep the weapon feature 
 * @author ShiyuanWang
 */
public class WeaponState extends PlayerState {

	public int weaponStyle = 0;
	public double weaponDamage = 0;

	private Weapon weapon = new Missile(
			TopDownImageUtil.getImage("images/game/bullet.png"));

	public WeaponState(Fighter fighter) {
		super(fighter);
	}

	public WeaponState(Fighter fighter, int numberOfBullet, double weaponDamage) {
		super(fighter);
		this.weaponStyle = numberOfBullet;
		this.weaponDamage = weaponDamage;
	}

	/**
	 * Set the properties of the weapon
	 */

	public void setWeapon(int weaponStyle, double weaponDamage) {
		this.weaponStyle = weaponStyle;
		this.weaponDamage = weaponDamage;
	}

	public void changeState(Object bullet) {
		this.weapon = (Weapon) bullet;
	}

	public void setWeaponStyle(int weaponStyle) {
		this.weaponStyle = weaponStyle;
	}

	public void setWeaponDamage(double weaponDamage) {
		this.weaponDamage = weaponDamage;
	}

	public int getWeaponStyle() {
		return weaponStyle;
	}

	public double getWeaponDamage() {
		return weaponDamage;
	}

	/**
	 * Generate different bullets according to the weapon state
	 */

	public void fire() {
		weapon.genBullets(fighter, weaponStyle, weaponDamage);
	}

	public void changeNumOFBullet(int change) {
		weaponStyle = change + weaponStyle;
	}

	public void changeWeaponDamage(double change) {
		weaponDamage = change + weaponDamage;
	}

	@Override
	public void update(long elapsedTime) {

	}

}