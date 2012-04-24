package demo.element;

import java.awt.image.BufferedImage;

import api.element.Bonus;
import api.element.Element;
import api.element.RegularFighter;
import api.element.TopDownPlayField;
import api.util.TopDownImageUtil;
/**
 * 
 * @author Yi Ding
 *
 */

public class DemoBonus3 extends Bonus {

	private Laser bullet;

	// = new Laser(
	// TopDownImageUtil.getImage("images/game/bigLaser1.png"));
	public DemoBonus3(TopDownPlayField playfield, BufferedImage image) {
		super(playfield, image);

		bullet = new Laser(
				TopDownImageUtil.getImage("images/game/bigLaser1.png"));

	}

	@Override
	public void collideAction(RegularFighter s1) {
		// TODO Auto-generated method stub
		s1.getWeaponState().changeState(bullet);
	}

	public Element clone() {
		DemoBonus3 db = new DemoBonus3(this.playfield, this.getImage());
		db.init();
		return db;
	}

}
