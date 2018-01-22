package com.scc;

import java.util.List;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry.Column;
import com.alibaba.otter.canal.protocol.CanalEntry.Entry;
import com.alibaba.otter.canal.protocol.CanalEntry.EventType;
import com.alibaba.otter.canal.protocol.CanalEntry.RowChange;
import com.alibaba.otter.canal.protocol.CanalEntry.RowData;
import com.alibaba.otter.canal.protocol.Message;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @ClassName: CanalClientTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2017年3月28日 下午3:40:56
 * 
 */
public class CanalClientTest {
	// canal多客户端会平分所有事件
	public static void main(String[] args) throws InterruptedException, InvalidProtocolBufferException {
		CanalConnector connector = CanalConnectors.newClusterConnector("172.16.40.4:2181", "db_172_16_40_5_3306", "",
				"");
		connector.connect();
		connector.subscribe("canal.t_canal");
		while (true) {
			Message message = connector.get(1);
			if (message.getEntries().size() > 0) {
				// System.out.println(message.getEntries().size());
			}
			for (Entry entry : message.getEntries()) {
				RowChange rowChange = RowChange.parseFrom(entry.getStoreValue());
				List<RowData> rows = rowChange.getRowDatasList();
				for (RowData rowData : rows) {
					EventType eventType = rowChange.getEventType();
					System.out.println(eventType);
					List<Column> beforecolumnsList = rowData.getBeforeColumnsList();
					for (Column column : beforecolumnsList) {
						System.out.println("before:" + column.getName() + "----" + column.getUpdated() + "----"
								+ column.hasUpdated());
					}
					List<Column> aftercolumnsList = rowData.getAfterColumnsList();
					for (Column column : aftercolumnsList) {
						System.out.println("after:" + column.getName() + "----" + column.getUpdated() + "----"
								+ column.hasUpdated());
					}
				}
			}
		}
	}
}
