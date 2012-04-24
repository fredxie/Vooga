package api.configuration;

/**
 * @author Ran Zhang
 */
import java.util.HashMap;

import api.element.RegularFighter;
import api.util.JsonUtil;


public class FighterKeyChangedObserver implements KeyChangedObserver {

	private RegularFighter fighter;

	public FighterKeyChangedObserver(RegularFighter fighter) {
		this.fighter = fighter;
		KeyChangedSubject.getInstance().registerObserver(this);
	}

	@Override
	public void changeKey() {
		HashMap<String, Integer> keyMap = JsonUtil.parse("json/keyConfig.json");
		for (Key key : fighter.getKeyList()) {
			key.setValue(keyMap.get(key.getAction()));
		}
	}

}
