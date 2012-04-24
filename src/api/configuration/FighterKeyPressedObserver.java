package api.configuration;


import api.element.RegularFighter;
import api.util.JsonUtil;
/**
 * Observer to observe the Fighter key changed events.
 * 
 * 
 * @author Ran Zhang
 */
public class FighterKeyPressedObserver implements KeyPressedObserver {

	private RegularFighter fighter;

	public FighterKeyPressedObserver(RegularFighter fighter) {
		this.fighter = fighter;
		KeyPressedSubject.getInstance().registerObserver(this);
	}

	/**
	 * When this observer is notified, iterate the key list to react to the
	 * pressed key.
	 * 
	 * 
	 * @return void
	 */
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

	/**
	 * 
	 * 
	 * @return the object that this observer is initiated in
	 */
	public Object getObject() {
		return fighter;
	}
}
