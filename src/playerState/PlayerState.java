package playerState;

import element.Fighter;

public abstract class PlayerState {
	
   protected Fighter fighter;
   public PlayerState(Fighter fighter)
   {
	this.fighter = fighter;   
   }
   public abstract void changeState(Object state);
   public abstract void update(long elapsedTime);

}
