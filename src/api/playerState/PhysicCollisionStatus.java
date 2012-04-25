package api.playerState;




import api.element.Fighter;
import api.element.RegularFighter;
import api.util.TopDownImageUtil;

import com.golden.gamedev.object.Timer;

import demo.element.DemoSatellite;

/**
 * This class extends CollisionStatus to perform as a concrete physics collisionStatus, called when collision
 * occurs, the class can decide the effect of collision
 * 
 * @author Yi Ding
 * 
 */
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
			fighter.getStateManager().changeCollisionState(new NormalCollisionStatus(state));
			fighter.getStateManager().changeAssistanceState(
					new DemoSatellite(TopDownImageUtil
							.getImage("images/game/Satellite.png"),
							fighter));

			fighter.getStateManager().genAssistance();

		}

	}

}