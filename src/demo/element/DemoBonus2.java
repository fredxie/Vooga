package demo.element;

import java.awt.image.BufferedImage;

import api.element.Bonus;
import api.element.Element;
import api.element.RegularFighter;
import api.element.TopDownPlayField;
import api.util.TopDownUtility;
/**
 * 
 * @author Yi Ding
 *
 */

public class DemoBonus2 extends Bonus {

	private int weaponDamage;

	public DemoBonus2(TopDownPlayField playfield, BufferedImage image) {
		super(playfield, image);
		weaponDamage = TopDownUtility.getRandom(0, 2);
	}

	@Override
	public void collideAction(RegularFighter s1) {
		// TODO Auto-generated method stub
		s1.getStateManager().changeWeaponDamage(weaponDamage);
	}

	public Element clone() {
		DemoBonus2 db = new DemoBonus2(this.playfield, this.getImage());
		db.init();
		return db;
	}

}
