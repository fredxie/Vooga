package demo.collisionSystem;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;



import api.collisionSystem.CollisionAction;
import api.element.TopDownPlayField;
import api.util.TopDownImageUtil;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.sprite.VolatileSprite;


public class ImageCollision extends CollisionAction {

	// private String explosion;
	private List<String> explosion;

	public ImageCollision(TopDownPlayField playfield, String... image) {
		this.playfield = playfield;
		explosion = new ArrayList<String>();
		for (String str : image)
			explosion.add(str);

	}

	@Override
	public void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub

		for (String str : explosion)
			playfield.add(new VolatileSprite(TopDownImageUtil.getImages(str, 6,
					1), s2.getX(), s2.getY()));

	}

}
