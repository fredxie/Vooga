package configuration.api;

/**
 * @author Ran Zhang
 */
import java.util.HashMap;


import util.JsonUtil;
import element.RegularFighter;

public class FighterKeyChangedObserver implements KeyChangedObserver {

	private RegularFighter fighter;

	public FighterKeyChangedObserver(RegularFighter fighter) {
		this.fighter = fighter;
		KeyChangedSubject.getInstance().registerObserver(this);
	}

	@Override
	public void changeKey() {
		// TODO Auto-generated method stub
		HashMap<GameParameters, Integer> keyMap = JsonUtil
				.parse("keyConfig.json");
		for (Key key : fighter.getKeyList()) {
			key.setValue(keyMap.get(key.getAction()));
		}
	}

}
