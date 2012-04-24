package demo.element;

/**
 * 
 * @author ShiyuanWang
 */
import java.awt.image.BufferedImage;

import api.element.Element;
import api.element.RegularFighter;
import api.element.Weapon;
import api.util.TopDownImageUtil;



public class DemoSatellite extends Satellite {
	private Weapon bullet = new Laser(
			TopDownImageUtil.getImage("images/game/beam3.png"));

	public DemoSatellite(BufferedImage image) {
		super(image);
		// TODO Auto-generated constructor stub
	}

	public DemoSatellite(BufferedImage image, RegularFighter fighter) {
		super(image, fighter);
		playfield.getGroup("Fighter").add(this);

	}

	@Override
	public Element clone() {
		// TODO Auto-generated method stub

		return new DemoSatellite(this.getImage());
	}

}