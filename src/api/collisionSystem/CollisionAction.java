package api.collisionSystem;

import api.game.TopDownPlayField;

import com.golden.gamedev.object.Sprite;

/**
 * This class is a piece of collision effect to act when a collision happens.
 * The effect is encapsulated in oncollide() method.
 * 
 * @author Yi Ding
 *
 */
public abstract class CollisionAction {

	protected TopDownPlayField playfield;

	public abstract void oncollide(Sprite s1, Sprite s2);

}
