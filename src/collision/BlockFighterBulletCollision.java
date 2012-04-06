package collision;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Sprite;

import element.TopDownPlayField;

public class BlockFighterBulletCollision extends TopDownCollision {

	public BlockFighterBulletCollision(TopDownPlayField field, BufferedImage[] images, String sound) 
	{
		super(field,images,sound);
	}
	
	public BlockFighterBulletCollision(TopDownPlayField field)
	{
		super(field);
	}

	public BlockFighterBulletCollision(TopDownPlayField field, BufferedImage[] images)
	{
		super(field,images );
	}
	
	public BlockFighterBulletCollision(TopDownPlayField field, String sound)
	{
		super(field, sound);
	}

	@Override
	public void collideEvent(Sprite s1, Sprite s2) {
          s2.setActive(false);		
	}

}
