package demo;

import java.awt.image.BufferedImage;

import util.TopDownImageUtil;
import element.Bonus;
import element.Element;
import element.Laser;
import element.RegularFighter;
import element.TopDownPlayField;

public class DemoBonus3 extends Bonus {
	
	private Laser bullet ;
	
//	= new Laser(
//			TopDownImageUtil.getImage("images/game/bigLaser1.png")); 
	public DemoBonus3(TopDownPlayField playfield, BufferedImage image) {
		super(playfield, image);

	    bullet =new Laser(
				TopDownImageUtil.getImage("images/game/bigLaser1.png")); 
		  
		}

	@Override
	public void collideAction(RegularFighter s1) {
		// TODO Auto-generated method stub
		s1.getWeaponState().changeState(bullet);
	}

	
	public Element clone() {
		DemoBonus3 db=new DemoBonus3(this.playfield, this.getImage());
		 db.init();
		return db;
	}

}
