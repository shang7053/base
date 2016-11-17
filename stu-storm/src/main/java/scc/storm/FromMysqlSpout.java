package scc.storm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

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

    private static final JdbcUtils jdbcUtils = new JdbcUtils();

    /*
     * (非 Javadoc) <p>Title: nextTuple</p> <p>Description: </p>
     * 
     * @see org.apache.storm.spout.ISpout#nextTuple()
     */
    public void nextTuple() {
        try {
            if (new Random().nextInt(100) > 50) {
                return;
            }
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
