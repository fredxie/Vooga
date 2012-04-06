package collision;

<<<<<<< HEAD
import demo.EnemyDestroyedCollision;
import element.Block;
import element.Bonus;
import element.Bullet;
import element.Element;
import element.Enemy;
import element.Fighter;
import element.TopDownPlayField;
import game.Configuration;

=======
>>>>>>> 06547cd22a3812a3a49734f264f682acfa7b902f
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
<<<<<<< HEAD
		// TODO Auto-generated method stub
		playfield.add(new VolatileSprite(explosion, s1.getX(), s1.getY()));
		((Enemy) s1).setHP(((Enemy) s1).getHP() - ((Bullet) s2).getDamage());
		if (((Enemy) s1).getHP() <= 0) {
			// if(((Enemy) s1).getLifeNum()==1)
			EnemyDestroyedCollision.destroyed++;
			s1.setActive(false);
			destroyed++;
			// else{
			//
			// ((Enemy) s1).setHP(Configuration.HP);
			//
			// ((Enemy) s1).setLifeNum(((Enemy) s1).getLifeNum()-1);
			// }
			//
		}
=======
>>>>>>> 06547cd22a3812a3a49734f264f682acfa7b902f

		((Enemy) s1).setHP(((Enemy) s1).getHP()-((Bullet) s2).getDamage());
		if (((Enemy) s1).getHP() <= 0 )
		{
            s1.setActive(false);
            destroyed++;

<<<<<<< HEAD
}
=======
			
		}		
	}
	
}
>>>>>>> 06547cd22a3812a3a49734f264f682acfa7b902f
