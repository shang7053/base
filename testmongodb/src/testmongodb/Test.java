package testmongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import util.DBUtil;

public class Test {
    @org.junit.Test
    public void testListAdd() {
        DBCollection collection = DBUtil.getDBCollection("listusertest");
        List<DBObject> basicDBObjects = new ArrayList<DBObject>();
        for (int i = 0; i < 10; i++) {
            DBObject b = new BasicDBObject();
            b.put("id", i);
            b.put("name", "zhangsan" + i);
            b.put("age", i);
            basicDBObjects.add(b);
        }
        collection.insert(basicDBObjects);
    }

    @org.junit.Test
    public void testAdd() {
        DBCollection collection = DBUtil.getDBCollection("usertest");
        int f = 0;
        List<DBObject> basicDBObjects = new ArrayList<DBObject>();
        for (int i = 0; i < 20000000; i++) {
            if (i == f * 10) {
                f++;
                if (0 == i) {
                    System.out.println("当前进度（0%）……");
                    continue;
                } else {
                    System.out.println("当前进度（" + (i / 20000000.00 * 100) + "%）……");
                }
            }
            if (i % 100 != 0) {
                DBObject user = new BasicDBObject();
                user.put("id", i);
                user.put("name", "zhangsan" + i);
                user.put("age", i);
                basicDBObjects.add(user);
            } else {
                collection.insert(basicDBObjects);
                basicDBObjects.clear();
            }
        }
        System.out.println("当前进度（100%）!");
    }

    @org.junit.Test
    public void testfind() {
        // mongoDB不支持联合查询、子查询，这需要我们自己在程序中完成。将查询的结果集在Java查询中进行需要的过滤即可。
        DBCollection collection = DBUtil.getDBCollection("usertest");
        DBObject user = new BasicDBObject();
        user.put("name", "zhangsan");
        user.put("age", "11");
        // 全部查询
        // DBCursor cursor=collection.find();
        // 条件查询
        DBCursor cursor = collection.find(new BasicDBObject("age", new BasicDBObject("$lte", 105)));
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    @org.junit.Test
    public void testDelete() {
        DBCollection collection = DBUtil.getDBCollection("testtable");
        // 根据id删除
        collection.remove(new BasicDBObject("_id", new ObjectId("5590e57b7d51ad2ef1b69a93")));
        // 条件删除
        collection.remove(new BasicDBObject("age", new BasicDBObject("$gte", 105)));
    }

    @org.junit.Test
    public void testUpdate() {
        DBCollection collection = DBUtil.getDBCollection("testtable");
        // 根据id修改
        collection.update(new BasicDBObject("_id", new ObjectId("5590e57b7d51ad2ef1b69a93")),
                new BasicDBObject("age", 99));
        // 条件修改
        collection.update(new BasicDBObject("age", new BasicDBObject("$gte", 105)), new BasicDBObject("age", 11));
    }
}
