package time.factory;

import com.mongodb.BasicDBObject;

import time.model.EinTime;
import time.model.EinTimeRange;
import time.querybuilder.DayQueryBuilder;
import time.querybuilder.MonthQueryBuilder;
import time.querybuilder.QueryBuilder;
import time.querybuilder.YearQueryBuilder;
public class QueryFactory {
	private QueryBuilder qb;
	public BasicDBObject getQuery(EinTimeRange timeRange) {
		if(timeRange.getBegin().getMonth() == 0) {
			qb = new YearQueryBuilder();
		}
		else if(timeRange.getBegin().getDay() == 0) {
			qb = new MonthQueryBuilder();
		}
		else {
			qb = new DayQueryBuilder();
		}
		return qb.getQuery(timeRange);
	}
	public BasicDBObject getQuery(EinTime time) {
		if(time.getMonth() == 0) {
			qb = new YearQueryBuilder();
		}
		else if(time.getDay() == 0) {
			qb = new MonthQueryBuilder();
		}
		else {
			qb = new DayQueryBuilder();
		}
		return qb.getQuery(time);
	}

}
