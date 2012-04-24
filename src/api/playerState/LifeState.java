package api.playerState;

import api.element.Fighter;
import api.element.RegularFighter;

public abstract class LifeState extends PlayerState {
	RegularFighter fighter;
	LifeState lifeState;

	public LifeState(Fighter fighter) {
		super(fighter);
	}

	public void changeState(Object lifeState) {
		this.lifeState = (LifeState) lifeState;
		this.lifeState.setPowerStatus();
	}

	public abstract void setPowerStatus();

	public void update() {

	}

}
