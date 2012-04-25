package api.collisionSystem;


import api.element.Bonus;
import api.element.RegularFighter;

import com.golden.gamedev.object.Sprite;

/**
 * This class extends CollisionAction. It defines the bonus collision effect when collides with fighter.
 * 
 * @author Yi Ding
 *
 */

public class BonusCollision extends CollisionAction {

	
	/**
	 * react bonus collision effects when collision happens
	 */
	@Override
	public void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub

		Bonus e2 = (Bonus) s2;
		RegularFighter e1 = (RegularFighter) s1;
		e2.collideAction(e1);

		s2.setActive(false);


	}

}
