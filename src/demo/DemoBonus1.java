package demo;

import java.awt.image.BufferedImage;

import util.TopDownUtility;
import element.Bonus;
import element.Element;
import element.RegularFighter;
import element.TopDownPlayField;

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
