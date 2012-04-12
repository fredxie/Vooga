package collisionSystem;

import java.awt.image.BufferedImage;

import util.TopDownImageUtil;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.sprite.VolatileSprite;

import element.TopDownPlayField;

public class ImageCollision extends CoolCollision{
	
	private String explosion;

	public ImageCollision(TopDownPlayField playfield, String image)
	{
		this.playfield = playfield;
		explosion = image;
		
	}
	
	@Override
	void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
		playfield.add(new VolatileSprite(TopDownImageUtil.getImages(
				explosion, 6, 1),s2.getX(),s2.getY()));

		
	}
	
	

}
