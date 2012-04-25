package api.collisionSystem;

import java.util.ArrayList;
import java.util.List;

import api.element.TopDownPlayField;

import com.golden.gamedev.object.Sprite;

/**
 * This class extends CollisionAction to help developer use sound effect in collision.
 * 
 * @param sound
 *           a list of sound to play
 * @author Yi Ding
 *
 */
public class SoundCollision extends CollisionAction {


	private List<String> sound;

	/**
	 * Constructor
	 * @param playfield
	 * @param sound
	 */
	public SoundCollision(TopDownPlayField playfield, String... sound) {
		this.playfield = playfield;
		this.sound = new ArrayList<String>();
		for (String str : sound)
			this.sound.add(str);
	}
	
	/**
	 * Overrride reaction method to play sound
	 */
	@Override
	public void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
		for (String str : sound)
			playfield.getGame().playSound(str);

	}

}
