package collision;

import java.awt.image.BufferedImage;

import collision.DestroyedOneCollision;

import com.golden.gamedev.object.PlayField;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import com.golden.gamedev.object.sprite.VolatileSprite;

import element.Bullet;
import element.Element;
import element.Fighter;
import game.Configuration;

public class FighterEnemyBulletCollision extends BasicCollisionGroup {

	private PlayField playfield;
	private BufferedImage[] explosion;

	public FighterEnemyBulletCollision(PlayField field, BufferedImage[] images) {
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
		playfield.add(new VolatileSprite(explosion, s2.getX(), s2.getY()));
		((Fighter) s1)
				.setHP(((Fighter) s1).getHP() - ((Bullet) s2).getDamage());
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
