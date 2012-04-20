package ai;

import com.golden.gamedev.object.Sprite;

public abstract class AI {
Sprite mySprite; 
	
	public AI() {
		
	}
	
	public void setSprite(Sprite s) {
		mySprite = s; 
	}
	
	public abstract void refresh(long elaspedTime);
	
	public abstract int getState();
}
