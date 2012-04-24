package demo.collisionSystem;

import java.util.ArrayList;
import java.util.List;


import api.collisionSystem.CollisionAction;
import api.element.TopDownPlayField;

import com.golden.gamedev.object.Sprite;


public class SoundCollision extends CollisionAction {

	// private String sound;
	private List<String> sound;

	public SoundCollision(TopDownPlayField playfield, String... sound) {
		this.playfield = playfield;
		this.sound = new ArrayList<String>();
		for (String str : sound)
			this.sound.add(str);
	}

	@Override
	public void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
		for (String str : sound)
			playfield.getGame().playSound(str);

	}

}
