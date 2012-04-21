package demo;

import java.awt.image.BufferedImage;

import playerState.CollisionState;
import element.Bonus;
import element.Element;
import element.RegularFighter;
import element.TopDownPlayField;

public class DemoBonus5 extends Bonus {
		
	
	private CollisionState state;
//	= new Laser(
//			TopDownImageUtil.getImage("images/game/bigLaser1.png")); 
	public DemoBonus5(TopDownPlayField playfield, BufferedImage image, CollisionState state) {
		super(playfield, image);
		this.state=state;
		  
		}

	@Override
	public void collideAction(RegularFighter s1) {
		// TODO Auto-generated method stub
		s1.getCollisionState().changeState(state);
		
	}

	
	public Element clone() {
		DemoBonus5 db=new DemoBonus5(this.playfield, this.getImage(),this.state);
		 db.init();
		return db;
	}

}
