package ai;
import game.Configuration;
import element.Enemy;

public class Brain2_Enemy extends AI {

	public void refresh(long elapsedTime) {
		mySprite.setSpeed(.1,.13);	
		((Enemy) mySprite).setRefireRate(900);
		AI.ENEMY_HP = 2.0;
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 2;
	}
}
