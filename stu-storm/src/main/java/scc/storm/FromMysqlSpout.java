package scc.storm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

/**
 * @ClassName: MysqlSpout
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年11月10日 下午4:26:38
 * 
 */
public class FromMysqlSpout extends BaseRichSpout {
	private Map conf;
	private TopologyContext context;
	private SpoutOutputCollector collector;

	/*
	 * (非 Javadoc) <p>Title: open</p> <p>Description: </p>
	 * 
	 * @param conf
	 * 
	 * @param context
	 * 
	 * @param collector
	 * 
	 * @see org.apache.storm.spout.ISpout#open(java.util.Map, org.apache.storm.task.TopologyContext,
	 * org.apache.storm.spout.SpoutOutputCollector)
	 */
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		this.conf = conf;
		this.collector = collector;
		this.context = context;
	}

	/*
	 * (非 Javadoc) <p>Title: nextTuple</p> <p>Description: </p>
	 * 
	 * @see org.apache.storm.spout.ISpout#nextTuple()
	 */
	public void nextTuple() {
		JdbcUtils jdbcUtils = new JdbcUtils();
		try {
			List<Map<String, Object>> data = jdbcUtils.findModeResult("select * from sds limit 1",
					new ArrayList<Object>());
			this.collector.emit(new Values(data));
		} catch (SQLException e) {
			e.printStackTrace();
			this.collector.reportError(e);
		}
	}

	/*
	 * (非 Javadoc) <p>Title: declareOutputFields</p> <p>Description: </p>
	 * 
	 * @param declarer
	 * 
	 * @see org.apache.storm.topology.IComponent#declareOutputFields(org.apache.storm.topology.OutputFieldsDeclarer)
	 */
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("data"));
	}

}
