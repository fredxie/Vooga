package collision;

import java.awt.image.BufferedImage;

import com.golden.gamedev.object.Sprite;

import element.Bonus;
import element.Fighter;

import element.RegularFighter;
import element.TopDownPlayField;

public class FighterBonusCollision extends TopDownCollision{

	public FighterBonusCollision(TopDownPlayField field, BufferedImage[] images,String sound) {
		super(field,images,sound);
	}

	public FighterBonusCollision(TopDownPlayField field)
	{
		super(field);
	}

	public FighterBonusCollision(TopDownPlayField field, BufferedImage[] images)
	{
		super(field,images );
	}
	public FighterBonusCollision(TopDownPlayField field, String sound)
	{
		super(field, sound);
	}

	@Override
	public void collideEvent(Sprite s1, Sprite s2) {

		s2.setActive(false);

		if (((Fighter) s1).getWeaponStyle() == (((Bonus) s2).getWeaponStyle()))
			((Fighter) s1)
					.setWeaponDamage(((Fighter) s1).getWeaponDamage() + 1);
		else {
			((Fighter) s1).setWeaponStyle(((Bonus) s2).getWeaponStyle());
			((Fighter) s1).setWeaponDamage(1);
		}

	}



}