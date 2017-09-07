package com.scc.dbtest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import com.voole.datasync.sdk.DataSyncCenter;

@Repository
public class SystemInit implements ApplicationContextAware {

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// insertdata();
		// randomquery();
		DataSyncCenter dsc = new DataSyncCenter();
		dsc.setZoo_adress("119.90.32.181:2181");
		dsc.setCbtopic("cbsynclog");
		dsc.regist("119_90_32_181_9092-voole_vrm-vrm_sp_authorlist-140000", DataDealImpl.class);
		dsc.regist("119_90_32_181_9092-voole_global-res_cpinfo", DataDealImpl.class);
		dsc.regist("119_90_32_181_9092-voole_global-res_imagedetail", DataDealImpl.class);
		dsc.regist("119_90_32_181_9092-voole_global-res_mediainfo", DataDealImpl.class);
		dsc.regist("119_90_32_181_9092-voole_global-res_movieinfo", DataDealImpl.class);
		dsc.regist("119_90_32_181_9092-voole_global-res_proprietary", DataDealImpl.class);
		dsc.regist("119_90_32_181_9092-voole_global-res_resourceinfo", DataDealImpl.class);
		dsc.init();
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
					sqls[1] = "update t_canal set address='"
							+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "' where id = 100";
					sqls[2] = "insert into t_canal (name,	age,	address) values('my name is "
							+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
							+ "',1,		'my address is "
							+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "')";
					String sql = sqls[new Random().nextInt(3)];
					DBUtil.insert(sql);
					try {
						Thread.currentThread().sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
