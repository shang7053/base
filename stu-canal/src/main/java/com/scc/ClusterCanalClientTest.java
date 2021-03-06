package com.scc;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry.Entry;
import com.alibaba.otter.canal.protocol.Message;

/**
 * @ClassName: CanalClientTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年3月28日 下午3:40:56
 * 
 */
public class ClusterCanalClientTest {
	// canal多客户端会平分所有事件
	public static void main(String[] args) throws InterruptedException {
		CanalConnector connector = CanalConnectors.newClusterConnector("172.16.40.4:2181,172.16.40.5:2181",
				"db_172_16_40_5_3306", "", "");
		connector.connect();
		connector.subscribe("canal.t_canal");
		while (true) {
			Message message = connector.get(1);
			if (message.getEntries().size() > 0) {
				System.out.println(message.getEntries().size());
			}
			for (Entry e : message.getEntries()) {
				System.out.println(e);
			}
			Thread.sleep(1000);
		}
	}
}
