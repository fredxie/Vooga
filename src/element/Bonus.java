package element;

import java.awt.image.BufferedImage;

public abstract class Bonus extends Element {

	// private int weaponDamage;
	private int weaponStyle;

	public boolean show = false;

	public Bonus(TopDownPlayField playfield, BufferedImage image) {
		super(image);
		this.playfield = playfield;
	}

	/*
	 * public int getweaponDamage(){ return weaponDamage; }
	 */

	public int getWeaponStyle() {
		return weaponStyle;
	}

	public void setWeaponStyle(int weaponStyle) {
		this.weaponStyle = weaponStyle;
	}

	public abstract void refresh(long elapsedTime);

}
