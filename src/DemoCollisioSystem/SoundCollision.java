package DemoCollisioSystem;

import java.util.ArrayList;
import java.util.List;

import collisionSystem.CollisionAction;

import com.golden.gamedev.object.Sprite;

import element.TopDownPlayField;

public class SoundCollision extends CollisionAction {
	
//    private String sound;
    private List<String> sound;
    
    public SoundCollision(TopDownPlayField playfield, String... sound)
    {
    	this.playfield = playfield;
    	this.sound = new ArrayList<String>();
    	for(String str: sound)
    	this.sound.add(str);
    }
    

	@Override
	public void oncollide(Sprite s1, Sprite s2) {
		// TODO Auto-generated method stub
		for(String str: sound)
		playfield.getGame().playSound(str);
		
		
		
	}
    

}