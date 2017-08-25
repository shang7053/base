package com.scc.dbtest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import com.voole.datasync.sdk.DataSyncCenter;

/**
 * @ClassName: Test
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年7月11日 上午9:42:27
 * 
 */
public class Test {

	public static void main(String[] args) {
		// insertdata();
		randomquery();
		DataSyncCenter dsc = new DataSyncCenter();
		dsc.setZoo_adress("172.16.40.4:2181,172.16.40.5:2182");
		// // 配置连接
		// // 注册处理类
		dsc.regist("testclientcb", DataDealImpl.class);
		dsc.regist("testclientcb2", DataDealImpl.class);
		dsc.init();
		// System.out.println(new Date(1499545977).toLocaleString());
		// Map<String, Object> data = new HashMap<String, Object>();
		// data.putAll(getmap());
		// System.out.println(data);
	}

	/**
	 * @Title: getmap
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年8月25日 下午2:34:35
	 * @return
	 */
	private static Map<? extends String, ? extends Object> getmap() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Title: randomquery
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年7月11日 下午12:14:56
	 */
	private static void randomquery() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (;;) {
					String[] sqls = new String[4];
					sqls[0] = "select * from t_canal where id=100";
					sqls[1] = "update t_canal set address='xxxx' where id = 100";
					sqls[2] = "insert into t_canal (name,	age,	address) values('my name is "
							+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
							+ "',1,		'my address is "
							+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "')";
					String sql = sqls[new Random().nextInt(3)];
					DBUtil.insert(sql);
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	/**
	 * @Title: insertdata
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author shangchengcai@voole.com
	 * @date 2017年7月11日 上午11:41:24
	 */
	private static void insertdata() {
		for (int i = 0; i < 50000; i++) {
			String sql = "INSERT INTO t_canal (	name,	age,	address,	createtime,	updatetime,	is_on,	version,	school) "
					+ "VALUES	(		'sss" + i + "',		" + i + ",		'sss" + i
					+ "',		now(),		now(),		" + i + ",		" + i + ",		'sss" + i + "'	);";
			DBUtil.insert(sql);
		}
	}

}
