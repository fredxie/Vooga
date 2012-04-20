package ai;

import element.Enemy;
import game.Configuration;

public class hpBrain_Enemy extends AI{
	double h;

	@Override
	public void refresh(long elaspedTime) {
		// TODO Auto-generated method stub
		double hSpeed = mySprite.getHorizontalSpeed();
		double vSpeed = mySprite.getVerticalSpeed();
		if (hSpeed > 0.05)
		{
			hSpeed = hSpeed - .03;
		}
		if( vSpeed > .08){
			vSpeed = vSpeed - .02; 
		}
		mySprite.setSpeed(hSpeed,vSpeed);

		int rate = ((Enemy) mySprite).getRefireRate();
		rate = rate + 150;
		((Enemy) mySprite).setRefireRate(rate);	
		
		double x = Configuration.ENEMY_HP;
		h = x - .5;
		Configuration.ENEMY_HP = h;
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}
}