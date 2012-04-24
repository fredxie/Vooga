package hud;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class RealTimeInfo implements HUDInfo {
	private DateTimeFormatter myFormatter = DateTimeFormat
			.forPattern("yyyy-MM-dd HH:mm:ss");

	public RealTimeInfo() {
	};

	@Override
	public String getString(Object obj) {
		return DateTime.now().toString(myFormatter);
	}

}
