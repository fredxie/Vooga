package demo;

import java.awt.image.BufferedImage;

import util.JsonUtil;
import configuration.api.GameParameters;

import element.Bonus;
import element.Element;
import element.RegularFighter;
import element.TopDownPlayField;
import game.Configuration;

public class DemoBonus4 extends Bonus {
		
//	= new Laser(
//			TopDownImageUtil.getImage("images/game/bigLaser1.png")); 
	public DemoBonus4(TopDownPlayField playfield, BufferedImage image) {
		super(playfield, image);
		  
		}

	@Override
	public void collideAction(RegularFighter s1) {
		// TODO Auto-generated method stub
		s1.setHP(JsonUtil.parse("paraConfig.json").get(
				GameParameters.FIGHTER_HP));
	}

	
	public Element clone() {
		DemoBonus4 db=new DemoBonus4(this.playfield, this.getImage());
		 db.init();
		return db;
	}

}
