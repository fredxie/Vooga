package collision;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Sprite;

import element.Fighter;
import element.TopDownPlayField;
import game.Configuration;

public class FighterBlockCollision extends TopDownCollision {

	public FighterBlockCollision(TopDownPlayField field, BufferedImage[] images, String sound) 
	{
		super(field,images,sound);
	}
	
	public FighterBlockCollision(TopDownPlayField field)
	{
		super(field);
	}

	public FighterBlockCollision(TopDownPlayField field, BufferedImage[] images)
	{
		super(field,images );
	}
	
	public FighterBlockCollision(TopDownPlayField field, String sound)
	{
		super(field, sound);
	}
	
	@Override
	public void collideEvent(Sprite s1, Sprite s2) {
		
		if(((Fighter) s1).getLifeNum()==1)
		{
			s1.setActive(false);
		}

			else{
				
			((Fighter) s1).setHP(Configuration.FIGHTER_HP);
				
			((Fighter) s1).setLifeNum(((Fighter) s1).getLifeNum()-1);
			}

	}

}
