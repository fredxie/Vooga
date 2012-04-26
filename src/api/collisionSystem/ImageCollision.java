package api.collisionSystem;

import java.util.ArrayList;
import java.util.List;

import api.game.TopDownPlayField;
import api.util.TopDownImageUtil;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.sprite.VolatileSprite;

/**
 * 
 * This class extends CollisionAction to help developer use image explosion effect in collision.
 * 
 * @param explosion
 *           a list of image explosion to show
 * @author Yi Ding
 *
 */

public class ImageCollision extends CollisionAction {

	// private String explosion;
	private List<String> explosion;

	/**
	 * Constructor
	 * 
	 * @param playfield
	 * @param image
	 */
	public ImageCollision(TopDownPlayField playfield, String... image) {
		this.playfield = playfield;
		explosion = new ArrayList<String>();
		for (String str : image)
			explosion.add(str);

	}

	/**
	 * Overrride reaction method to show explosion
	 */
	@Override
	public void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub

		for (String str : explosion)
			playfield.add(new VolatileSprite(TopDownImageUtil.getImages(str, 6,
					1), s2.getX(), s2.getY()));

	}

}
