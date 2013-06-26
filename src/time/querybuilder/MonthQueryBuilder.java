package time.querybuilder;

import java.util.ArrayList;

import time.model.EinTime;
import time.model.EinTimeRange;

import com.mongodb.BasicDBObject;

public class MonthQueryBuilder extends QueryBuilder{

	@Override
	public BasicDBObject getQuery(EinTimeRange timeRange) {
		
		return queryHelper(timeRange.getBegin().getYear(), timeRange.getEnd().getYear(), timeRange.getBegin().getMonth(), timeRange.getEnd().getMonth());
	}

	@Override
	public BasicDBObject getQuery(EinTime beginTime, EinTime endTime) {
		return queryHelper(beginTime.getYear(), endTime.getYear(), beginTime.getMonth(), endTime.getMonth());
	}

	public BasicDBObject queryHelper(int beginYear, int endYear, int beginMonth, int endMonth) {
		ArrayList<BasicDBObject> queryList = new ArrayList<BasicDBObject>();
		
		
		BasicDBObject beginQuery = new BasicDBObject("year", beginYear)
		.append("month", new BasicDBObject("$gte",beginMonth))
		.append("month", new BasicDBObject("$lte",12));
		queryList.add(beginQuery);
		
		if(beginYear != endYear) {
			BasicDBObject midQuery = new BasicDBObject("year", new BasicDBObject("$gte", beginYear+1))
			.append("year", new BasicDBObject("$lte", endYear-1));
			queryList.add(midQuery);
		}
		
		BasicDBObject endQuery = new BasicDBObject("year", endYear)
		.append("month", new BasicDBObject("$gte",1))
		.append("month", new BasicDBObject("$lte",endMonth));
		
		
		queryList.add(endQuery);
		BasicDBObject orQuery = new BasicDBObject("$or",queryList);
		
		return orQuery;
	}

	@Override
	public BasicDBObject getQuery(EinTime time) {
		BasicDBObject query = new BasicDBObject("year", time.getYear())
		.append("month", time.getMonth());
		return query;
	}
}
