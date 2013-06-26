package time.handler;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import time.factory.QueryFactory;
import time.factory.TimeFactory;
import time.model.EinTime;
import time.model.EinTimeRange;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.ServerAddress;
import com.mongodb.MongoClient;
public class Mongo {
	DBCollection coll = null;
	public Mongo() {
		
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient( "localhost" , 27017 );
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DB db = mongoClient.getDB( "datetest" );
		coll = db.getCollection("eincell");
	}
	public void init() {
		BasicDBObject doc1 = new BasicDBObject("val",1).append("date", "2013-5-23");
		BasicDBObject doc2 = new BasicDBObject("val",2).append("date", "2014-3-23");
		BasicDBObject doc3 = new BasicDBObject("val",3).append("date", "2015-9-23");
		BasicDBObject doc4 = new BasicDBObject("val",4).append("date", "2013");
		BasicDBObject doc5 = new BasicDBObject("val",5).append("date", "2013-10");
		BasicDBObject doc6 = new BasicDBObject("val",6).append("date", "2014-5");
		BasicDBObject doc7 = new BasicDBObject("val",7).append("date", "2015");
		BasicDBObject doc8 = new BasicDBObject("val",8).append("date", "2013-5-23");
		coll.insert(doc1);
		coll.insert(doc2);
		coll.insert(doc3);
		coll.insert(doc4);
		coll.insert(doc5);
		coll.insert(doc6);
		coll.insert(doc7);
		coll.insert(doc8);
		
	}
	//query model time range: 2013-12-13 to 2015-11-13
	//mongo cell time contains: month, day, year
	
	//filter select based on time
	//ex: selection based on day from 13 to 13
	//select year < 2013 and year >2015
	//month 
	
	//select start range
	
	//select mid range
	
	//select end range
	
	
	
	
	public void queryMapper(String time) {
		
	}
	
	
	public ArrayList<EinTimeRange> readQueryModelTime(String queryModelTime) {
		List<String> times = Arrays.asList(queryModelTime.split(","));
		
		for (String time : times) {
			TimeFactory tf = new TimeFactory();
			QueryFactory qf = new QueryFactory();
			ArrayList<EinTime> einTimes = tf.getEinTime(time);
			if(einTimes.size() == 2) {
				qf.getQuery(new EinTimeRange(einTimes.get(0),einTimes.get(1)));
			}
			else {
				qf.getQuery(einTimes.get(0));
			}
		}
		return null;
	}
	
	public EinTimeRange parseTimeToEinTimeRange(String timeStr) {
		
		
		
		return null;
	}
	

}
