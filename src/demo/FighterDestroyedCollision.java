package demo;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.sprite.VolatileSprite;

import collision.DestroyedBothCollision;

public class FighterDestroyedCollision extends DestroyedBothCollision{
	
	private PlayField playfield;
	private BufferedImage[] explosion;
	
	public FighterDestroyedCollision(PlayField field, BufferedImage[] images) {
		super();
		playfield = field;
		explosion = images;
	}

	@Override
	public void collideEvent(Sprite s1, Sprite s2) {

		playfield.add(new VolatileSprite(explosion, s2.getX(), s2.getY()));
		//need to reset data(maybe)
	}

}
