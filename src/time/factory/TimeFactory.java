package time.factory;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import time.model.EinTime;
import time.parser.DayTimeParser;
import time.parser.MonthTimeParser;
import time.parser.TimeParser;
import time.parser.YearTimeParser;

public class TimeFactory {
	private TimeParser timeParser;
	private ArrayList<EinTime> timeList;
	public ArrayList<EinTime> getEinTime(String timeStr) {
		
		//input: time
		//input: time->time
		
		timeList = new ArrayList<EinTime>();
		if(timeStr.matches(timeParser.DAYPATTERN)) {
			Pattern dayPattern = Pattern.compile(timeParser.DAYPATTERN);
			Matcher m = dayPattern.matcher(timeStr);
			timeParser = new DayTimeParser();
			while(m.find()) {
				timeList.add(timeParser.parse(m.group()));
			}
			return timeList;
		}
		else if(timeStr.matches(timeParser.MONTHPATTERN)) {
			Pattern monthPattern = Pattern.compile(timeParser.MONTHPATTERN);
			Matcher m = monthPattern.matcher(timeStr);
			timeParser = new MonthTimeParser();
			while(m.find()) {
				timeList.add(timeParser.parse(m.group()));
			}
			return timeList;
		}
		else if(timeStr.matches(timeParser.YEARPATTERN)) {
			Pattern yearPattern = Pattern.compile(timeParser.YEARPATTERN);
			Matcher m = yearPattern.matcher(timeStr);
			timeParser = new YearTimeParser();
			while(m.find()) {
				timeList.add(timeParser.parse(m.group()));
			}
			return timeList;
		}
		
		return null;
	}

}
