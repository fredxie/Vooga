package api.playerState;

import api.element.Fighter;

/**
 * This class performs as the root class of player state class which is waiting
 * to be extended
 * 
 * @author ShiyuanWang
 */
public abstract class PlayerState {

	protected Fighter fighter;

	public PlayerState(Fighter fighter) {
		this.fighter = fighter;
	}

	public abstract void changeState(Object state);

	public abstract void update(long elapsedTime);

	public Fighter getFighter()
	{
		return fighter;
	}

}