package time.parser;

import time.model.EinTime;

abstract public class TimeParser {
	public final String DAYPATTERN = "((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
	public final String MONTHPATTERN = "((19|20)\\d\\d)-(0?[1-9]|1[012])";
	public final String YEARPATTERN = "((19|20)\\d\\d)";
	abstract public EinTime parse(String timeStr);
}
