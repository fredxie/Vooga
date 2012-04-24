package DemoCollisioSystem;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import util.TopDownImageUtil;

import collisionSystem.CollisionAction;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.sprite.VolatileSprite;

import element.TopDownPlayField;

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
