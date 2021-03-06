package demo.HUD;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import api.HUD.DisplayText;

public class RealTimeText extends DisplayText {
	private DateTimeFormatter myFormatter = DateTimeFormat
			.forPattern("yyyy-MM-dd HH:mm:ss");
	
	public RealTimeText() {
		super();
	}
	
	@Override
	public String getString() {
		return DateTime.now().toString(myFormatter);
	}

}
