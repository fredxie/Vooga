

package demo;
/**
 * 
 * @author ShiyuanWang
 */
import java.awt.image.BufferedImage;

import util.TopDownImageUtil;
import DemoElement.Laser;
import DemoElement.Satellite;
import element.Element;
import element.RegularFighter;

import element.Weapon;

public class DemoSatellite extends Satellite
{
	private Weapon bullet = new Laser(TopDownImageUtil.getImage("images/game/beam3.png"));
	public DemoSatellite(BufferedImage image) {
		super(image);
		// TODO Auto-generated constructor stub
	}
	public DemoSatellite(BufferedImage image,RegularFighter fighter) {
		super(image, fighter);
		playfield.getGroup("Fighter").add(this);

	}

	@Override
	public Element clone() {
		// TODO Auto-generated method stub

		return new DemoSatellite(this.getImage());
	}


}