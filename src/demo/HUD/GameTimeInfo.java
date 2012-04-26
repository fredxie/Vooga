package demo.HUD;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import api.HUD.DisplayText;

public class GameTimeInfo extends DisplayText {
	private DateTime myTime;
	
	public GameTimeInfo(DateTime startTime) {
		super();
		myTime = startTime;
	}
	
	@Override
	public String getString() {
		DateTime now = DateTime.now();		
		Duration dur = new Duration(myTime, now);
		
		return dur.toString().toString().substring(2);
	}

}
