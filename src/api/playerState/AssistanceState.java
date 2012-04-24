package api.playerState;

import api.element.AutoFighter;
import api.element.Fighter;
import api.element.RegularFighter;

public class AssistanceState extends PlayerState {

	AutoFighter autoFighter;

	public AssistanceState(Fighter fighter) {
		super(fighter);
		autoFighter = ((RegularFighter) fighter).assistance;

	}

	@Override
	public void changeState(Object state) {
		autoFighter = (AutoFighter) state;

	}

	public void genAssistance() {
		((RegularFighter) fighter).assistance = autoFighter
				.produce(autoFighter);

	}

	@Override
	public void update(long elapsedTime) {
		if (autoFighter != null)
			((RegularFighter) fighter).assistance.fighterControl(elapsedTime);

	}

}
