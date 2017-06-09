package com.scc;

import java.net.InetSocketAddress;

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
public class CanalClientTest {
	// canal多客户端会平分所有事件
	public static void main(String[] args) throws InterruptedException {
		CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress("172.16.41.156", 11111),
				"db_172_16_41_11_3306_voole_global_res_resourceinfo", "", "");
		connector.connect();
		connector.subscribe("voole_global.res_resourceinfo");
		while (true) {
			Message message = connector.get(1);
			if (message.getEntries().size() > 0) {
				System.out.println(message.getEntries().size());
			}
			for (Entry e : message.getEntries()) {
				// System.out.println(e);
			}
			Thread.sleep(1000);
		}
	}
}
