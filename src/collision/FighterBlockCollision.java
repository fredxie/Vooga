package collision;

import java.awt.image.BufferedImage;

import collision.DestroyedOneCollision;

import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import com.golden.gamedev.object.sprite.VolatileSprite;

import element.Block;
import element.Bullet;
import element.Element;
import element.Fighter;
import game.Configuration;

public class FighterBlockCollision extends BasicCollisionGroup{

	private PlayField playfield;
	private BufferedImage[] explosion;
	
	public FighterBlockCollision(PlayField field, BufferedImage[] images) {
		super();
		playfield = field;
		explosion = images;
	}

	public void collided(Fighter s1, Block s2) {
		s2.setActive(false);

		collideEvent(s1, s2);

	}

	public void collideEvent(Element s1, Element s2) {
		// TODO Auto-generated method stub
		playfield.add(new VolatileSprite(explosion, s1.getX(), s1.getY()));
		if(((Fighter) s1).getLifeNum()==1)
			s1.setActive(false);

			else{
				
			((Fighter) s1).setHP(Configuration.HP);
				
			((Fighter) s1).setLifeNum(((Fighter) s1).getLifeNum()-1);
			}
			
	}		

	@Override
	public void collided(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
		
	}



}
