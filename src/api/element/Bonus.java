package api.element;


import java.awt.image.BufferedImage;

import api.game.TopDownPlayField;
import api.util.JsonUtil;
import api.util.TopDownAreaUtil;
import api.util.TopDownUtility;
import demo.game.DemoGameEngine;

/**
 * This class defines Bonus Sprite to help developer use Bonus.
 * 
 * @author Yi Ding
 *
 */
@SuppressWarnings("serial")
public abstract class Bonus extends Element {

	// private int weaponDamage;

	public boolean show = false;

	public Bonus(TopDownPlayField playfield, BufferedImage image) {
		super(image);
		this.playfield = playfield;
	}

	/**
	 * refresh bonus status when update.
	 * 
	 * @param elapsedTime
	 */

	public void refresh(long elapsedTime) {
		if (show == false) { // bonus has not been shown
			if (getY() + getHeight() < playfield.getBackground().getY()
					+ DemoGameEngine.HEIGHT
					&& getY() > playfield.getBackground().getY()) {
				// show the bonus
				setSpeed(TopDownUtility.getRandom(-1, 1) / 20.0, JsonUtil
						.parse("json/paraConfig.json").get("BACKGROUND_SPEED")
						/ 10.0 + TopDownUtility.getRandom(0, 1) / 20.0);
				playfield.getGroup("Bonus").add(this);
				show = true;
			}
		}
	}

	/**
	 * Update bonus
	 * 
	 */
	public void update(long elapsedTime) {
		super.update(elapsedTime);
		TopDownAreaUtil.limitArea(this, playfield.getTileBackground(),
				DemoGameEngine.HEIGHT, DemoGameEngine.WIDTH);
	}

	/**
	 * initiate bonus
	 */
	public void init() {
		// this.setWeaponDamage();
		// this.setWeaponStyle(TopDownUtility.getRandom(0, 2));
		// this.setWeaponStyle(TopDownUtility.getRandom(0,
		// Configuration.BONUS_STYLE_NUM - 1));
		this.setX(TopDownUtility.getRandom(0,
				DemoGameEngine.WIDTH - this.getWidth()));
		this.setY(TopDownUtility.getRandom(150, playfield.getBackground()
				.getHeight() - DemoGameEngine.HEIGHT));
	}

	/**
	 * define the effect when bonus is eaten by fighter
	 * 
	 * @param s1
	 */
	public abstract void collideAction(RegularFighter s1);

}
