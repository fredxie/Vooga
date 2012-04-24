package demo.playerState;

/**
 * Yi Ding
 */

import api.element.Fighter;
import api.element.RegularFighter;
import api.playerState.AssistanceState;
import api.playerState.CollisionState;
import api.playerState.CollisionStatus;
import api.util.TopDownImageUtil;

import com.golden.gamedev.object.Timer;

import demo.element.DemoSatellite;


public class PhysicCollisionStatus extends CollisionStatus {

	Timer validDuration = new Timer(10000);

	public PhysicCollisionStatus(CollisionState state) {

		super(state);
		collisionID = "Shield";
	}

	@Override
	public void update(long elapsedTime) {
		// TODO Auto-generated method stub

		if (validDuration.action(elapsedTime)) {
			RegularFighter fighter = (RegularFighter) state.getFighter();
			state.changeState(new NormalCollisionStatus(state));
			fighter.getAssistanceState().changeState(
					new DemoSatellite(TopDownImageUtil
							.getImage("images/game/Satellite.png"),
							fighter));
			
			
	((AssistanceState) fighter.getAssistanceState()).genAssistance();
			
		}

	}

}
