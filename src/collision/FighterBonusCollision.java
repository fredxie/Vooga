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

public class FighterBonusCollision extends BasicCollisionGroup {

	private TopDownPlayField playfield;
	private BufferedImage[] explosion;

	public FighterBonusCollision(TopDownPlayField field, BufferedImage[] images) {
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
		if (((Fighter) s1).getWeaponStyle() == (((Bonus) s2).getWeaponStyle()))
			((Fighter) s1)
					.setWeaponDamage(((Fighter) s1).getWeaponDamage() + 1);
		else {
			((Fighter) s1).setWeaponStyle(((Bonus) s2).getWeaponStyle());
			((Fighter) s1).setWeaponDamage(1);
		}

	}

}
