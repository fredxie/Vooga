package demo;

import java.awt.image.BufferedImage;

import util.TopDownAreaUtil;
import util.TopDownUtility;
import element.Bonus;
import element.TopDownPlayField;
import game.Configuration;

public class DemoBonus extends Bonus{

	
	public DemoBonus(TopDownPlayField playfield, BufferedImage image) {
		super(playfield, image);
	}


	public void init() {
	  //this.setWeaponDamage();
		this.setWeaponStyle(TopDownUtility.getRandom(0,Configuration.BONUS_STYLE_NUM-1));
		this.setX(TopDownUtility.getRandom(0, DemoGameEngine.WIDTH
				- this.getWidth()));
		this.setY(TopDownUtility.getRandom(150, playfield.getBackground().getHeight()
				- DemoGameEngine.HEIGHT));
	}

	@Override
	public void refresh(long elapsedTime) {
		if (show == false) { // bonus has not been shown
			if (getY() + getHeight() < playfield.getBackground().getY()
					+ DemoGameEngine.HEIGHT
					&& getY() > playfield.getBackground().getY()) {
				// show the bonus
				setSpeed(TopDownUtility.getRandom(-1, 1)/20.0, Configuration.BACKGROUND_SPEED+TopDownUtility.getRandom(0, 1)/20.0);
				playfield.getGroup("Bonus").add(this);
				show = true;
			}
		}
	}
	
	public void update(long elapsedTime) {
		super.update(elapsedTime);
		TopDownAreaUtil.limitArea(this, playfield.getTileBackground(), DemoGameEngine.HEIGHT, DemoGameEngine.WIDTH);
	}
	

}
