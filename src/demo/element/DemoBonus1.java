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

public class DemoBonus1 extends Bonus {

	private int weaponStyle;

	public DemoBonus1(TopDownPlayField playfield, BufferedImage image) {
		super(playfield, image);
		weaponStyle = TopDownUtility.getRandom(0, 2);
	}

	@Override
	public void collideAction(RegularFighter s1) {
		// TODO Auto-generated method stub
		s1.getWeaponState().setWeaponStyle(weaponStyle);
	}

	public Element clone() {
		DemoBonus1 db = new DemoBonus1(this.playfield, this.getImage());
		db.init();
		return db;
	}

}
