package element;

import game.TopDownGameObject;
import gameObject.GameLevel;

import java.awt.image.BufferedImage;

public abstract class AutoFighter extends Fighter{
	
	protected RegularFighter master;
	GameLevel game;
	
	public AutoFighter(BufferedImage image) {
		super(image);
	}

	public AutoFighter(BufferedImage image, RegularFighter fighter) {
		super(image);
		master = fighter;
		init();
	}

	public abstract void init();
    public abstract void setBrinkVerticalSpeed();
    public abstract void setBrinkHorizontalSpeed();
    public RegularFighter getMaster()
    {
    	return master;
    }

	public void produce(Fighter fighter) {
		fighter.playfield.add(this);
	}

	public abstract void fighterControl(long elapsedTime);

}
