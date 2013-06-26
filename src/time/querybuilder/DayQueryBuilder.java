package time.querybuilder;

import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import time.model.EinTime;
import time.model.EinTimeRange;

public class DayQueryBuilder extends QueryBuilder{
	
	@Override
	public BasicDBObject getQuery(EinTimeRange timeRange) {
		return queryHelper(timeRange.getBegin().getYear(), timeRange.getEnd().getYear(), timeRange.getBegin().getMonth(), timeRange.getEnd().getMonth(), timeRange.getBegin().getDay(), timeRange.getEnd().getDay());
	}
	
	@Override
	public BasicDBObject getQuery(EinTime beginTime, EinTime endTime) {
		return queryHelper(beginTime.getYear(), endTime.getYear(), beginTime.getMonth(), endTime.getMonth(), beginTime.getDay(), endTime.getDay());
	}
	
	public BasicDBObject queryHelper(int beginYear, int endYear, int beginMonth, int endMonth, int beginDay, int endDay) {
		ArrayList<BasicDBObject> queryList = new ArrayList<BasicDBObject>();

		BasicDBObject beginQuery = new BasicDBObject("year", beginYear)
		.append("month", beginMonth)
		.append("day", new BasicDBObject("$gte",beginDay))
		.append("day", new BasicDBObject("$lte", 31));
		
		queryList.add(beginQuery);
		if(beginYear != endYear) {
			BasicDBObject midQuery = new BasicDBObject("year", new BasicDBObject("$gte", beginYear+1))
			.append("year", new BasicDBObject("$lte", endYear-1));
			queryList.add(midQuery);
		}
		else if(beginMonth != endMonth) {
			BasicDBObject midQuery = new BasicDBObject("year", beginYear)
			.append("month", new BasicDBObject("$gte", beginMonth+1))
			.append("month", new BasicDBObject("$lte", endMonth-1));
			queryList.add(midQuery);
		}
		BasicDBObject endQuery = new BasicDBObject("year", endYear)
		.append("month", endMonth)
		.append("day", new BasicDBObject("$gte",1))
		.append("day", new BasicDBObject("$lte",endDay));
		queryList.add(endQuery);
		
		BasicDBObject orQuery = new BasicDBObject("$or", queryList);
		return orQuery;
	}

	@Override
	public BasicDBObject getQuery(EinTime time) {
		BasicDBObject query = new BasicDBObject("year", time.getYear())
		.append("month", time.getMonth())
		.append("day", time.getDay());
		return query;
	}

}
