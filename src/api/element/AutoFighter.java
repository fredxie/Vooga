package api.element;

import java.awt.image.BufferedImage;

/**
 * This class designed the AutoFighter extending Fighter, which is the fighter
 * cannot be controlled but assist the fighter.
 * 
 * @author Shiyuan Wang
 * 
 */

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

	/**
	 * Return the master fighter of this AutoFighter
	 */

	public RegularFighter getMaster() {
		return master;
	}

	/**
	 * Produce the autoFighter to assist the master Fighter
	 */

	public AutoFighter produce(Fighter fighter) {
		fighter.playfield.add(this);
		return this;
	}

	/**
	 * AutoFighter takes action according to the action of Master Fighter and
	 * time
	 */

	public abstract void fighterControl(long elapsedTime);

}
