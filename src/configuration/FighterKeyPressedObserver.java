package configuration;

/**
 * @author Ran Zhang
 */

import util.JsonUtil;
import element.RegularFighter;

public class FighterKeyPressedObserver implements KeyPressedObserver {

	private RegularFighter fighter;

	public FighterKeyPressedObserver(RegularFighter fighter) {
		this.fighter = fighter;
		KeyPressedSubject.getInstance().registerObserver(this);
	}

	@Override
	public void pressKey(long elapsedTime) {
		// TODO Auto-generated method stub
		fighter.setSpeed(0, 0);
		for (Key key : fighter.getKeyList()) {
			if (key.isKeyDown()) {
				key.executeKeyFuction(elapsedTime);
			}
		}
		fighter.setVerticalSpeed(fighter.getVerticalSpeed()
				- JsonUtil.parse("paraConfig.json").get(
						GameParameters.BACKGROUND_SPEED) / 10.0);
	}

	@Override
	public Object getObject() {
		// TODO Auto-generated method stub
		return fighter;
	}
}
