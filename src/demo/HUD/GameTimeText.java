package demo.HUD;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import api.HUD.DisplayText;

public class GameTimeText extends DisplayText {
	private DateTime myTime;
	
	public GameTimeText(DateTime startTime) {
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
