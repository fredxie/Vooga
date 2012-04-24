package api.configuration;
import java.util.HashMap;

import api.element.RegularFighter;
import api.util.JsonUtil;

/**
 * Observer to observe the Fighter key changed events.
 * 
 * 
 * @author Ran Zhang
 */
public class FighterKeyChangedObserver implements KeyChangedObserver {

	private RegularFighter fighter;

	public FighterKeyChangedObserver(RegularFighter fighter) {
		this.fighter = fighter;
		KeyChangedSubject.getInstance().registerObserver(this);
	}

	/**
	 * When this observer is notified, change key correspondingly.
	 * 
	 * 
	 * @return void
	 */
	public void changeKey() {
		HashMap<String, Integer> keyMap = JsonUtil.parse("json/keyConfig.json");
		for (Key key : fighter.getKeyList()) {
			key.setValue(keyMap.get(key.getAction()));
		}
	}

}
