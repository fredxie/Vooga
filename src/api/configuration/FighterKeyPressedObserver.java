package api.configuration;

/**
 * @author Ran Zhang
 */

import api.element.RegularFighter;
import api.util.JsonUtil;

public class FighterKeyPressedObserver implements KeyPressedObserver {

	private RegularFighter fighter;

	public FighterKeyPressedObserver(RegularFighter fighter) {
		this.fighter = fighter;
		KeyPressedSubject.getInstance().registerObserver(this);
	}

	@Override
	public void pressKey(long elapsedTime) {
		fighter.setSpeed(0, 0);
		for (Key key : fighter.getKeyList()) {
			if (key.isKeyDown()) {
				key.executeKeyFuction(elapsedTime);
			}
		}
		fighter.setVerticalSpeed(fighter.getVerticalSpeed()
				- JsonUtil.parse("json/paraConfig.json").get("BACKGROUND_SPEED")
				/ 10.0);
	}

	@Override
	public Object getObject() {
		return fighter;
	}
}
