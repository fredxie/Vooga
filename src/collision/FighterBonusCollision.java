package collision;

import element.Block;
import element.Bonus;
import element.Element;
import element.Fighter;
import element.TopDownPlayField;
import game.Configuration;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import com.golden.gamedev.object.sprite.VolatileSprite;

public class FighterBonusCollision extends BasicCollisionGroup{

	private TopDownPlayField playfield;
	private BufferedImage[] explosion;
	
	public FighterBonusCollision(TopDownPlayField field, BufferedImage[] images) {
		super();
		playfield = field;
		explosion = images;
	}

	public void collided(Fighter s1, Bonus s2) {
		s2.setActive(false);

		collideEvent(s1, s2);

	}

	public void collideEvent(Element s1, Element s2) {
		// TODO Auto-generated method stub
		playfield.add(new VolatileSprite(explosion, s2.getX(), s2.getY()));
        if(((Fighter) s1).getStyle()==(((Bonus) s2).getStyle())
        ((Fighter) s1).setDamage(((Fighter) s1).getDamage()++);
        else
        	{
        	((Fighter) s1).setStyle(((Bonus) s2).getStyle());
        	((Fighter) s1).setDamage(1);
        	}

			
	}

	@Override
	public void collided(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
		
	}		


	
}
