package playerState;

import element.AutoFighter;
import element.Fighter;
import element.RegularFighter;

public class AssistanceState extends PlayerState{

	AutoFighter autoFighter;
	public AssistanceState(Fighter fighter) {
		super(fighter);
		
	}

	@Override
	public void changeState(Object state) {
		autoFighter = (AutoFighter)state;
	}

	
	public void genAssistance() {
		((RegularFighter)fighter).assistance= autoFighter.produce(autoFighter);
		
	}

	@Override
	public void update(long elapsedTime) {
		// TODO Auto-generated method stub
		
	}


}
