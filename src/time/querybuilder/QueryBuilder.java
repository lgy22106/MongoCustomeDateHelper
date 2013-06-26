package time.querybuilder;

import time.model.EinTime;
import time.model.EinTimeRange;

import com.mongodb.BasicDBObject;

abstract public class QueryBuilder {
	abstract public BasicDBObject getQuery(EinTimeRange timeRange);
	abstract public BasicDBObject getQuery(EinTime beginTime, EinTime endTime);
	abstract public BasicDBObject getQuery(EinTime time);
}
