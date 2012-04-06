package collision;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.sprite.VolatileSprite;

import element.Bullet;
import element.Fighter;
import element.RegularFighter;
import element.TopDownPlayField;
import game.Configuration;

public class FighterEnemyBulletCollision extends TopDownCollision {

	public FighterEnemyBulletCollision(TopDownPlayField field, BufferedImage[] images,String sound) {
		super(field,images,sound);
	}
	
	public FighterEnemyBulletCollision(TopDownPlayField field)
	{
		super(field);
	}

	public FighterEnemyBulletCollision(TopDownPlayField field, BufferedImage[] images)
	{
		super(field,images );
	}
	public FighterEnemyBulletCollision(TopDownPlayField field, String sound)
	{
		super(field, sound);
	}
	
    public void collideEvent(Sprite s1, Sprite s2) {
		
	((Fighter) s1).setHP(((Fighter) s1).getHP() - ((Bullet) s2).getDamage());
	if (((Fighter) s1).getHP() <= 0) {
		if (((Fighter) s1).getLifeNum() == 1)
			s1.setActive(false);
		else {

			((Fighter) s1).setHP(Configuration.FIGHTER_HP);

			((Fighter) s1).setLifeNum(((Fighter) s1).getLifeNum() - 1);
		}

	}

}
}
