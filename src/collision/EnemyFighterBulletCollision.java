package collision;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Sprite;


import element.Bullet;
import element.Enemy;
import element.TopDownPlayField;

public class EnemyFighterBulletCollision extends TopDownCollision{

	public static int destroyed=0;

	public EnemyFighterBulletCollision(TopDownPlayField field, BufferedImage[] images,String sound) {
		super(field,images,sound);
	}
	
	public EnemyFighterBulletCollision(TopDownPlayField field)
	{
		super(field);
	}

	public EnemyFighterBulletCollision(TopDownPlayField field, BufferedImage[] images)
	{
		super(field,images );
	}
	public EnemyFighterBulletCollision(TopDownPlayField field, String sound)
	{
		super(field, sound);

	}
	@Override
	public void collideEvent(Sprite s1, Sprite s2) {

		((Enemy) s1).setHP(((Enemy) s1).getHP()-((Bullet) s2).getDamage());
		if (((Enemy) s1).getHP() <= 0 )
		{
            s1.setActive(false);
            destroyed++;

			
		}		
	}
	
}
