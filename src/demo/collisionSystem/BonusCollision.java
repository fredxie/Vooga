package demo.collisionSystem;


import api.collisionSystem.CollisionAction;
import api.element.Bonus;
import api.element.Fighter;
import api.element.RegularFighter;

import com.golden.gamedev.object.Sprite;


public class BonusCollision extends CollisionAction {

	@Override
	public void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub

		Bonus e2 = (Bonus) s2;
		RegularFighter e1 = (RegularFighter) s1;
		e2.collideAction(e1);

		s2.setActive(false);

		// if (((Fighter) s1).getWeaponStyle() == (((Bonus)
		// s2).getWeaponStyle()))
		// ((Fighter) s1)
		// .setWeaponDamage(((Fighter) s1).getWeaponDamage() + 1);
		// else {
		// ((Fighter) s1).setWeaponStyle(((Bonus) s2).getWeaponStyle());
		// ((Fighter) s1).setWeaponDamage(1);
		// }

	}

}
