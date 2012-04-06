package collision;

import demo.EnemyDestroyedCollision;
import element.Block;
import element.Bonus;
import element.Bullet;
import element.Element;
import element.Enemy;
import element.Fighter;
import element.TopDownPlayField;
import game.Configuration;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import com.golden.gamedev.object.sprite.VolatileSprite;

public class EnemyFighterBulletCollision extends BasicCollisionGroup {

	private TopDownPlayField playfield;
	private BufferedImage[] explosion;
	public static int destroyed = 0;

	public EnemyFighterBulletCollision(TopDownPlayField field,
			BufferedImage[] images) {
		super();
		playfield = field;
		explosion = images;
	}

	public void collided(Sprite s1, Sprite s2) {
		s2.setActive(false);

		collideEvent(s1, s2);

	}

	public void collideEvent(Sprite s1, Sprite s2) {
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

	}

}
