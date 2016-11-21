/**   
 *
 * @Title: HbaseConfig.java 
 * @Package scc.hbase 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年11月21日 下午2:34:18   
 */
package scc.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;

/**
 *
 * @ClassName: HbaseConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年11月21日 下午2:34:18
 * 
 */
public class HbaseTest {
    public Configuration configuration;
    public HTable hTable;
    public HBaseAdmin hBaseAdmin;
    public Connection connection;

    /**
     *
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @author scc
     * @date 2016年11月21日 下午2:36:52
     */
    public HbaseTest() {
        this.configuration = HBaseConfiguration.create();
        this.configuration.set("hbase.master", "hadoop-n:60000");
        this.configuration.set("hbase.zookeeper.property.clientPort", "2181");
        this.configuration.set("hbase.zookeeper.quorum", "hadoop-n,hadoop-d1,hadoop-d2");
        try {
            this.connection = ConnectionFactory.createConnection(this.configuration);
            this.hBaseAdmin = (HBaseAdmin) this.connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        HbaseTest hbaseTest = new HbaseTest();
        hbaseTest.droptable();
        hbaseTest.createtab();
        hbaseTest.putdata();
        hbaseTest.getdata();
    }

    /**
     *
     * @Title: getdata
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年11月21日 下午3:25:41
     */
    private void getdata() {
        try {
            Table table = this.connection.getTable(TableName.valueOf("test_snappy2"));
            Get get = new Get("a".getBytes());
            Result result = table.get(get);
            if (null != result) {
                for (Cell cell : result.rawCells()) {
                    System.out.println("列簇为：" + new String(cell.getFamily()));
                    System.out.println("列修饰符为：" + new String(cell.getQualifier()));
                    System.out.println("值为：" + new String(cell.getValue()));
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     *
     * @Title: droptable
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年11月21日 下午3:17:16
     */
    private void droptable() {
        try {
            if (this.hBaseAdmin.tableExists("test_snappy2")) {
                if (!this.hBaseAdmin.isTableDisabled("test_snappy2")) {
                    this.hBaseAdmin.disableTable("test_snappy2");
                }
                this.hBaseAdmin.deleteTable("test_snappy2");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @Title: putdata
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年11月21日 下午2:56:24
     */
    private void putdata() {
        try {
            Table table = this.connection.getTable(TableName.valueOf("test_snappy2"));
            Put put = new Put("a".getBytes());
            put.addColumn("colfam".getBytes(), "val1".getBytes(), "colfam1".getBytes());
            table.put(put);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @Title: createtab
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年11月21日 下午2:42:54
     */
    private void createtab() {
        try {
            HTableDescriptor descriptor = new HTableDescriptor(TableName.valueOf("test_snappy2"));
            descriptor.addFamily(new HColumnDescriptor("colfam"));
            if (!this.hBaseAdmin.tableExists("test_snappy2")) {
                this.hBaseAdmin.createTable(descriptor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
