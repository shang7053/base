package scc.storm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;

/**
 * @ClassName: ToFileBolt
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年11月10日 下午4:44:09
 * 
 */
public class ToFileBolt extends BaseRichBolt {
    private Map conf;
    private TopologyContext context;
    private OutputCollector collector;

    /*
     * (非 Javadoc) <p>Title: prepare</p> <p>Description: </p>
     * 
     * @param stormConf
     * 
     * @param context
     * 
     * @param collector
     * 
     * @see org.apache.storm.task.IBolt#prepare(java.util.Map, org.apache.storm.task.TopologyContext,
     * org.apache.storm.task.OutputCollector)
     */
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        this.conf = this.conf;
        this.collector = collector;
        this.context = context;
    }

    /*
     * (非 Javadoc) <p>Title: execute</p> <p>Description: </p>
     * 
     * @param input
     * 
     * @see org.apache.storm.task.IBolt#execute(org.apache.storm.tuple.Tuple)
     */
    public void execute(Tuple input) {
        List<Map<String, Object>> data = (List<Map<String, Object>>) input.getValueByField("data");
        String outdata = data.toString() + "\r\n";
        File file = new File("\\opt\\jstorm\\stormtest.txt");
        if (!file.exists()) {
            new File("\\opt\\jstorm").mkdirs();
            try {
                new File("\\opt\\jstorm\\stormtest.txt").createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file, true);
            fos.write(outdata.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
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
        // TODO Auto-generated method stub

    }

}
