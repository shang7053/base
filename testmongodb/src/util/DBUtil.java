package util;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Properties;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class DBUtil {
	private static Properties p=new Properties();
	private static String host;
	private static int port;
	private static String dbname;
	static{
		try {
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			host=(String) p.get("host");
			port=Integer.valueOf((String) p.get("port"));
			dbname=(String) p.get("dbname");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static DBCollection getDBCollection(String tablename){
		try {
			 return new MongoClient(host,port).getDB(dbname).getCollection(tablename);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static DBObject getDBCursorFromJson(String jsondata){
		return (DBObject) JSON.parse(jsondata);
	}
	public static String getStringDataFromDBObject(DBObject entry){
		return JSON.serialize(entry);
	}
}
