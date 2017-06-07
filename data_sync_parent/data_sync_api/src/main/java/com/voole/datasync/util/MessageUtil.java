package com.voole.datasync.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.otter.canal.protocol.CanalEntry.Column;
import com.alibaba.otter.canal.protocol.CanalEntry.Entry;
import com.alibaba.otter.canal.protocol.CanalEntry.EntryType;
import com.alibaba.otter.canal.protocol.CanalEntry.EventType;
import com.alibaba.otter.canal.protocol.CanalEntry.RowChange;
import com.alibaba.otter.canal.protocol.CanalEntry.RowData;
import com.alibaba.otter.canal.protocol.CanalEntry.TransactionBegin;
import com.alibaba.otter.canal.protocol.CanalEntry.TransactionEnd;
import com.alibaba.otter.canal.protocol.Message;
import com.google.protobuf.InvalidProtocolBufferException;

public class MessageUtil {
	protected final static Logger logger = LoggerFactory.getLogger(MessageUtil.class);
	protected static final String SEP = SystemUtils.LINE_SEPARATOR;
	protected static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	protected volatile boolean running = false;
	protected Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			logger.error("parse events has an error", e);
		}
	};
	protected Thread thread = null;
	protected static String context_format = null;
	protected static String row_format = null;
	protected static String transaction_format = null;
	protected String destination;
	static {
		context_format = SEP + "****************************************************" + SEP;
		context_format += "* Batch Id: [{}] ,count : [{}] , memsize : [{}] , Time : {}" + SEP;
		context_format += "* Start : [{}] " + SEP;
		context_format += "* End : [{}] " + SEP;
		context_format += "****************************************************" + SEP;

		row_format = SEP
				+ "----------------> binlog[{}:{}] , name[{},{}] , eventType : {} , executeTime : {} , delay : {}ms"
				+ SEP;

		transaction_format = SEP + "================> binlog[{}:{}] , executeTime : {} , delay : {}ms" + SEP;

	}

	public static void printMessage(Message message) {
		printSummary(message);
		printEntry(message.getEntries());
	}

	public static void printSummary(Message message) {
		long memsize = 0;
		for (Entry entry : message.getEntries()) {
			memsize += entry.getHeader().getEventLength();
		}
		String startPosition = null;
		String endPosition = null;
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
		if (!CollectionUtils.isEmpty(message.getEntries())) {
			startPosition = buildPositionForDump(message.getEntries().get(0));
			endPosition = buildPositionForDump(message.getEntries().get(message.getEntries().size() - 1));
			logger.debug(context_format, new Object[] { message.getId(), message.getEntries().size(), memsize,
					format.format(new Date()), startPosition, endPosition });
		} else {
			logger.debug(context_format, new Object[] { message.getId(), message.getEntries().size(), memsize,
					format.format(new Date()), startPosition, endPosition });
		}

	}

	protected static String buildPositionForDump(Entry entry) {
		long time = entry.getHeader().getExecuteTime();
		Date date = new Date(time);
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
		return entry.getHeader().getLogfileName() + ":" + entry.getHeader().getLogfileOffset() + ":"
				+ entry.getHeader().getExecuteTime() + "(" + format.format(date) + ")";
	}

	public static void printEntry(List<Entry> entrys) {
		for (Entry entry : entrys) {
			long executeTime = entry.getHeader().getExecuteTime();
			long delayTime = new Date().getTime() - executeTime;

			if (entry.getEntryType() == EntryType.TRANSACTIONBEGIN
					|| entry.getEntryType() == EntryType.TRANSACTIONEND) {
				if (entry.getEntryType() == EntryType.TRANSACTIONBEGIN) {
					TransactionBegin begin = null;
					try {
						begin = TransactionBegin.parseFrom(entry.getStoreValue());
					} catch (InvalidProtocolBufferException e) {
						throw new RuntimeException("parse event has an error , data:" + entry.toString(), e);
					}
					// 打印事务头信息，执行的线程id，事务耗时
					logger.debug(transaction_format,
							new Object[] { entry.getHeader().getLogfileName(),
									String.valueOf(entry.getHeader().getLogfileOffset()),
									String.valueOf(entry.getHeader().getExecuteTime()), String.valueOf(delayTime) });
					logger.debug(" BEGIN ----> Thread id: {}", begin.getThreadId());
				} else if (entry.getEntryType() == EntryType.TRANSACTIONEND) {
					TransactionEnd end = null;
					try {
						end = TransactionEnd.parseFrom(entry.getStoreValue());
					} catch (InvalidProtocolBufferException e) {
						throw new RuntimeException("parse event has an error , data:" + entry.toString(), e);
					}
					// 打印事务提交信息，事务id
					logger.debug("----------------\n");
					logger.debug(" END ----> transaction id: {}", end.getTransactionId());
					logger.debug(transaction_format,
							new Object[] { entry.getHeader().getLogfileName(),
									String.valueOf(entry.getHeader().getLogfileOffset()),
									String.valueOf(entry.getHeader().getExecuteTime()), String.valueOf(delayTime) });
				}

				continue;
			} else if (entry.getEntryType() == EntryType.ROWDATA) {
				RowChange rowChage = null;
				try {
					rowChage = RowChange.parseFrom(entry.getStoreValue());
				} catch (Exception e) {
					throw new RuntimeException("parse event has an error , data:" + entry.toString(), e);
				}

				EventType eventType = rowChage.getEventType();

				logger.debug(row_format,
						new Object[] { entry.getHeader().getLogfileName(),
								String.valueOf(entry.getHeader().getLogfileOffset()), entry.getHeader().getSchemaName(),
								entry.getHeader().getTableName(), eventType,
								String.valueOf(entry.getHeader().getExecuteTime()), String.valueOf(delayTime) });

				if (eventType == EventType.QUERY || rowChage.getIsDdl()) {
					logger.debug(" sql ----> " + rowChage.getSql());
					continue;
				}
				if (eventType == EventType.DELETE) {
					for (RowData rowData : rowChage.getRowDatasList()) {
						printColumn(rowData.getBeforeColumnsList());
					}
				} else if (eventType == EventType.INSERT) {
					for (RowData rowData : rowChage.getRowDatasList()) {
						printColumn(rowData.getAfterColumnsList());
					}
				} else if (eventType == EventType.UPDATE) {
					for (RowData rowData : rowChage.getRowDatasList()) {
						printColumn(rowData.getAfterColumnsList());
					}
				}

			}
		}
	}

	static private void printColumn(List<Column> columns) {
		StringBuilder builder = new StringBuilder();
		for (Column column : columns) {
			builder.append("(" + column.getName() + " : " + column.getValue());
			builder.append(" type=" + column.getMysqlType());
			if (column.getUpdated()) {
				builder.append(" update=" + column.getUpdated());
			}
			builder.append(")");
		}
		logger.info(builder.toString());
	}

}
