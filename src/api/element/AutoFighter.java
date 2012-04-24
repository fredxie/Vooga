package api.element;


import java.awt.image.BufferedImage;

import api.game.TopDownGameObject;
import api.gameLevel.GameLevel;

public abstract class AutoFighter extends Fighter {

	protected RegularFighter master;

	public abstract void init();

	public abstract void setBrinkVerticalSpeed();

	public abstract void setBrinkHorizontalSpeed();

	public AutoFighter(BufferedImage image) {
		super(image);
	}

	public AutoFighter(BufferedImage image, RegularFighter fighter) {
		super(image);
		master = fighter;
		init();
	}

	public RegularFighter getMaster() {
		return master;
	}

	public AutoFighter produce(Fighter fighter) {
		fighter.playfield.add(this);
		return this;
	}

	public abstract void fighterControl(long elapsedTime);

}