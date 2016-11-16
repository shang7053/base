package scc.storm;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.utils.Utils;

/**
 * @ClassName: MyTopology
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年11月10日 下午4:52:05
 * 
 */
public class MyTopology {
    public static void main(String[] args)
            throws AlreadyAliveException, InvalidTopologyException, AuthorizationException {
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("frommysql", new FromMysqlSpout());
        builder.setBolt("tofile", new ToFileBolt()).shuffleGrouping("frommysql");
        Config conf = new Config();
        conf.setDebug(true);
        if (args != null && args.length > 0) {
            conf.setNumWorkers(3);
            StormSubmitter.submitTopology(args[0], conf, builder.createTopology());
        } else {
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("firstTopo", conf, builder.createTopology());
            Utils.sleep(100000);
            cluster.killTopology("firstTopo");
            cluster.shutdown();
        }
    }
}
