<<<<<<< HEAD
package demo;

import java.awt.image.BufferedImage;

import configuration.GameParameters;

import util.JsonUtil;
import util.TopDownAreaUtil;
import util.TopDownUtility;
import element.Bonus;
import element.Element;
import element.TopDownPlayField;
import game.Configuration;

public class DemoBonus extends Bonus {

	public DemoBonus(TopDownPlayField playfield, BufferedImage image) {
		super(playfield, image);
	}

	public void init() {
		// this.setWeaponDamage();
		this.setWeaponStyle(TopDownUtility.getRandom(0, 2));
		this.setWeaponStyle(TopDownUtility.getRandom(0,
				Configuration.BONUS_STYLE_NUM - 1));
		this.setX(TopDownUtility.getRandom(0,
				DemoGameEngine.WIDTH - this.getWidth()));
		this.setY(TopDownUtility.getRandom(150, playfield.getBackground()
				.getHeight() - DemoGameEngine.HEIGHT));
	}

	@Override
	public void refresh(long elapsedTime) {
		if (show == false) { // bonus has not been shown
			if (getY() + getHeight() < playfield.getBackground().getY()
					+ DemoGameEngine.HEIGHT
					&& getY() > playfield.getBackground().getY()) {
				// show the bonus
				setSpeed(
						TopDownUtility.getRandom(-1, 1) / 20.0,
						JsonUtil.parse("paraConfig.json").get(GameParameters.BACKGROUND_SPEED)/10.0
								+ TopDownUtility.getRandom(0, 1) / 20.0);
				playfield.getGroup("Bonus").add(this);
				show = true;
			}
		}
	}

	public void update(long elapsedTime) {
		super.update(elapsedTime);
		TopDownAreaUtil.limitArea(this, playfield.getTileBackground(),
				DemoGameEngine.HEIGHT, DemoGameEngine.WIDTH);
	}

	@Override
	public Element clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
=======
package demo;

import java.awt.image.BufferedImage;

import configuration.GameParameters;

import util.JsonUtil;
import util.TopDownAreaUtil;
import util.TopDownUtility;
import element.Bonus;
import element.Element;
import element.TopDownPlayField;
import game.Configuration;

public class DemoBonus extends Bonus {

	public DemoBonus(TopDownPlayField playfield, BufferedImage image) {
		super(playfield, image);
	}

	public void init() {
		// this.setWeaponDamage();
		this.setWeaponStyle(TopDownUtility.getRandom(0, 2));
		this.setWeaponStyle(TopDownUtility.getRandom(0,
				Configuration.BONUS_STYLE_NUM - 1));
//		this.setX(TopDownUtility.getRandom(0,
//				DemoGameEngine.WIDTH - this.getWidth()));
//		this.setY(TopDownUtility.getRandom(150, playfield.getBackground()
//				.getHeight() - DemoGameEngine.HEIGHT));
	}

	@Override
	public void refresh(long elapsedTime) {
		if (show == false) { // bonus has not been shown
			if (getY() + getHeight() < playfield.getBackground().getY()
					+ DemoGameEngine.HEIGHT
					&& getY() > playfield.getBackground().getY()) {
				// show the bonus
				setSpeed(
						TopDownUtility.getRandom(-1, 1) / 20.0,
						JsonUtil.parse("paraConfig.json").get(GameParameters.BACKGROUND_SPEED)/10.0
								+ TopDownUtility.getRandom(0, 1) / 20.0);
				playfield.getGroup("Bonus").add(this);
				show = true;
			}
		}
	}

	public void update(long elapsedTime) {
		super.update(elapsedTime);
		TopDownAreaUtil.limitArea(this, playfield.getTileBackground(),
				DemoGameEngine.HEIGHT, DemoGameEngine.WIDTH);
	}

	@Override
	public Element clone() {
		DemoBonus db=new DemoBonus(this.playfield, this.getImage());
		 db.init();
		return db;
	}

}
>>>>>>> ada42b2f157034c49af47fe8c2b0fb0d4d6625ad
