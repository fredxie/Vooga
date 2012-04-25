package demo.element;

import java.awt.image.BufferedImage;

import api.element.Bonus;
import api.element.Element;
import api.element.RegularFighter;
import api.element.TopDownPlayField;
import api.util.JsonUtil;
/**
 * 
 * @author Yi Ding
 *
 */


@SuppressWarnings("serial")
public class DemoBonus4 extends Bonus {

	// = new Laser(
	// TopDownImageUtil.getImage("images/game/bigLaser1.png"));
	public DemoBonus4(TopDownPlayField playfield, BufferedImage image) {
		super(playfield, image);

	}

	@Override
	public void collideAction(RegularFighter s1) {
		// TODO Auto-generated method stub
		s1.setHP(JsonUtil.parse("json/paraConfig.json").get("FIGHTER_HP"));
	}

	public Element clone() {
		DemoBonus4 db = new DemoBonus4(this.playfield, this.getImage());
		db.init();
		return db;
	}

}
