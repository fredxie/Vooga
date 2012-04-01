package demo;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.sprite.VolatileSprite;

import collision.DestroyedBothCollision;

public class EnemyDestroyedCollision extends DestroyedBothCollision{
	
	private PlayField playfield;
	private BufferedImage[] explosion;
	public static int destroyed = 0;
	
	public EnemyDestroyedCollision(PlayField field, BufferedImage[] images) {
		super();
		playfield = field;
		explosion = images;
	}

	@Override
	public void collideEvent(Sprite s1, Sprite s2) {

		playfield.add(new VolatileSprite(explosion, s2.getX(), s2.getY()));
		destroyed++;
	}

}
