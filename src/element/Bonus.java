package element;

import game.Configuration;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Sprite;

import util.JsonUtil;
import util.TopDownAreaUtil;
import util.TopDownUtility;
import configuration.api.GameParameters;
import demo.DemoGameEngine;

public abstract class Bonus extends Element {

	// private int weaponDamage;

	public boolean show = false;

	public Bonus(TopDownPlayField playfield, BufferedImage image) {
		super(image);
		this.playfield = playfield;
	}

	/*
	 * public int getweaponDamage(){ return weaponDamage; }
	 */

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
	
	
	public void init() {
		// this.setWeaponDamage();
//		this.setWeaponStyle(TopDownUtility.getRandom(0, 2));
//		this.setWeaponStyle(TopDownUtility.getRandom(0,
//				Configuration.BONUS_STYLE_NUM - 1));
		this.setX(TopDownUtility.getRandom(0,
				DemoGameEngine.WIDTH - this.getWidth()));
		this.setY(TopDownUtility.getRandom(150, playfield.getBackground()
				.getHeight() - DemoGameEngine.HEIGHT));
	}
	
	public abstract void collideAction(RegularFighter s1);
	
	
	
}
