package collisionSystem;

import com.golden.gamedev.object.Sprite;

import element.TopDownPlayField;

public abstract class CollisionAction {
	
	protected TopDownPlayField playfield;
	
	public abstract void oncollide(Sprite s1, Sprite s2);

}
