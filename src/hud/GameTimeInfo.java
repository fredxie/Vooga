package hud;

import org.joda.time.DateTime;
import org.joda.time.Duration;

public class GameTimeInfo implements HUDInfo {

	@Override
	public String getString(Object obj) {
		DateTime start = (DateTime) obj;
		DateTime now = DateTime.now();
		
		Duration dur = new Duration(start, now);
		return dur.toString().toString().substring(2);
	}

}
