package collision;

import java.awt.image.BufferedImage;


import com.golden.gamedev.object.Sprite;

import element.Fighter;
import element.RegularFighter;
import element.TopDownPlayField;
import game.Configuration;


public class FighterEnemyCollision extends TopDownCollision{

	
	public FighterEnemyCollision(TopDownPlayField field, BufferedImage[] images,String sound) {
		super(field,images,sound);
	}
	
	public FighterEnemyCollision(TopDownPlayField field)
	{
		super(field);
	}

	public FighterEnemyCollision(TopDownPlayField field, BufferedImage[] images)
	{
		super(field,images );
	}
	public FighterEnemyCollision(TopDownPlayField field, String sound)
	{
		super(field, sound);
	}

	public void collideEvent(Sprite s1, Sprite s2) {
		

		if(((Fighter) s1).getLifeNum()==1)
		{
			((Fighter) s1).setLifeNum(0);
			s1.setActive(false);

		}

		else {

			((Fighter) s1).setHP(Configuration.FIGHTER_HP);

			((Fighter) s1).setLifeNum(((Fighter) s1).getLifeNum() - 1);
		}

	}

}
