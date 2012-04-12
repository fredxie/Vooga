package collisionSystem;

import com.golden.gamedev.object.Sprite;

import element.TopDownPlayField;

public abstract class CoolCollision {
	
	protected TopDownPlayField playfield;
	
	abstract void oncollide(Sprite s1, Sprite s2);

}
