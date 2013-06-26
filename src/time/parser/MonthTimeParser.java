package time.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import time.model.EinTime;

public class MonthTimeParser extends TimeParser {
	@Override
	public EinTime parse(String timeStr) {
		Date d = null;
		try {
			d = new SimpleDateFormat("yyyy-MM").parse(timeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		
		return new EinTime(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1);
	}
	

}
