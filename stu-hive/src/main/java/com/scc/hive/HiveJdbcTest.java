/**   
 *
 * @Title: HiveJdbcTest.java 
 * @Package com.scc.hive 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年11月9日 上午10:16:32   
 */
package com.scc.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @ClassName: HiveJdbcTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年11月9日 上午10:16:32
 * 
 */
public class HiveJdbcTest {
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}

		Connection con = DriverManager.getConnection("jdbc:hive2://60.29.252.4:10000/default", "statuser",
				"statuser*()");
		String tableName = "adstat";
		String sql = "";
		ResultSet res = null;
		Statement stmt = con.createStatement();
		// sql = "describe " + tableName;
		sql = "select hid from adstat where hid='0C49330E181A'";
		res = stmt.executeQuery(sql);
		while (res.next()) {
			// System.out.println(res.getString(1) + "\t" + res.getString(2));
			System.out.println(res.getObject(1));
		}

		/*
		 * for (int i = 0; i < 10000000; i++) { sql =
		 * "INSERT INTO l_access(id,req_name,req_version,req_param,req_no,req_status,req_desc,ret,excute_time,req_time,create_time) "
		 * + "VALUES(" + (1000 + i) +
		 * ",'第三方播放串生成','1.0','34324324324','04f07d2f9a7046eda0a7796643fb9de7','0','成功','saddsdsd','697'," + new
		 * Date().getTime() + "," + new Date().getTime() + ")"; System.out.println(sql); PreparedStatement stmt =
		 * con.prepareStatement(sql); stmt.executeUpdate(sql); System.out.println(i + 1); }
		 */
		/*
		 * sql = "select * from " + tableName + " where id=112244 limit 10"; res = stmt.executeQuery(sql); while
		 * (res.next()) { System.out.println(new Date(res.getLong("excute_time")).toString()); }
		 */

		/*
		 * sql = "select sum(id),req_name from " + tableName + " group by req_name"; long avg = 0; long lastval = 0; for
		 * (int i = 0; i < 500; i++) { long start = System.currentTimeMillis(); res = stmt.executeQuery(sql); while
		 * (res.next()) { System.out.print("count:" + res.getString(1) + "req_name:" + res.getString("req_name"));
		 * break; } long cost = (System.currentTimeMillis() - start); System.out.println(",cost(ms):" + cost); avg =
		 * (lastval + cost) / (i + 1); lastval += cost; } System.out.println(avg);
		 */
	}
}
