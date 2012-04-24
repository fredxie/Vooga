package api.collisionSystem;

import api.element.TopDownPlayField;

import com.golden.gamedev.object.Sprite;


public abstract class CollisionAction {

	protected TopDownPlayField playfield;

	public abstract void oncollide(Sprite s1, Sprite s2);

}
