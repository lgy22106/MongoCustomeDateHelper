package time.querybuilder;

import time.model.EinTime;
import time.model.EinTimeRange;

import com.mongodb.BasicDBObject;

public class YearQueryBuilder extends QueryBuilder {

	@Override
	public BasicDBObject getQuery(EinTimeRange timeRange) {
		return queryHelper(timeRange.getBegin().getYear(), timeRange.getEnd().getYear());
	}

	@Override
	public BasicDBObject getQuery(EinTime beginTime, EinTime endTime) {
		return queryHelper(beginTime.getYear(), endTime.getYear());
	} 
	
	public BasicDBObject queryHelper(int beginYear, int endYear) {
		BasicDBObject query = new BasicDBObject("year", new BasicDBObject("$gte",beginYear)
		.append("year", new BasicDBObject("$lte",endYear)));
		return query;
	}

	@Override
	public BasicDBObject getQuery(EinTime time) {
		BasicDBObject query = new BasicDBObject("year", time.getYear());
		return query;
	}
	

}
