package demo;
/**
 * 
 * @author ShiyuanWang
 */
import java.awt.image.BufferedImage;

import util.TopDownImageUtil;

import element.Bullet;
import element.Element;
import element.Laser;
import element.RegularFighter;
import element.Satellite;

public class DemoSatellite extends Satellite
{
	private Bullet bullet = new Laser(TopDownImageUtil.getImage("images/game/beam3.png"));
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