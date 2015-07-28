package testmongodb;

import org.bson.types.ObjectId;
import util.DBUtil;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class Test {
	@org.junit.Test
	public void testAdd(){
		DBCollection collection=DBUtil.getDBCollection("testtable");
		DBObject user=new BasicDBObject();
		user.put("name", "zhangsan");
		user.put("age", 11);
		collection.insert(user).getN();
	}
	@org.junit.Test
	public void testfind(){
		//mongoDB不支持联合查询、子查询，这需要我们自己在程序中完成。将查询的结果集在Java查询中进行需要的过滤即可。
		DBCollection collection=DBUtil.getDBCollection("testtable");
		DBObject user=new BasicDBObject();
		user.put("name", "zhangsan");
		user.put("age", "11");
		//全部查询
		//DBCursor cursor=collection.find();
		//条件查询
		DBCursor cursor=collection.find(new BasicDBObject("age", new BasicDBObject("$lte", 105)));
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}
	@org.junit.Test
	public void testDelete(){
		DBCollection collection=DBUtil.getDBCollection("testtable");
		//根据id删除
		collection.remove(new BasicDBObject("_id", new ObjectId("5590e57b7d51ad2ef1b69a93")));
		//条件删除
		collection.remove(new BasicDBObject("age", new BasicDBObject("$gte", 105)));
	}
	@org.junit.Test
	public void testUpdate(){
		DBCollection collection=DBUtil.getDBCollection("testtable");
		//根据id修改
		collection.update(new BasicDBObject("_id", new ObjectId("5590e57b7d51ad2ef1b69a93")), new BasicDBObject("age", 99));
		//条件修改
		collection.update(new BasicDBObject("age", new BasicDBObject("$gte", 105)), new BasicDBObject("age", 11));
	}
}
