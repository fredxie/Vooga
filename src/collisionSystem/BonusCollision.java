package collisionSystem;

import com.golden.gamedev.object.Sprite;

import element.Bonus;
import element.Fighter;

public class BonusCollision extends CoolCollision{

	@Override
	void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
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
