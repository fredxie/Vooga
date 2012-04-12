package collisionSystem;

import com.golden.gamedev.object.Sprite;

import element.TopDownPlayField;

public class SoundCollision extends CoolCollision {
	
    private String sound;
    
    public SoundCollision(TopDownPlayField playfield, String sound)
    {
    	this.playfield = playfield;
    	this.sound = sound;
    }
    

	@Override
	void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
		playfield.getGame().playSound(sound);
		
		
		
	}
    

}
