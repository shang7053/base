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
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.util.Bytes;

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
    public ExecutorService executorService = Executors.newFixedThreadPool(5);

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
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = ConnectionFactory.createConnection(this.configuration, this.executorService);
            this.hBaseAdmin = (HBaseAdmin) connection.getAdmin();
            return connection;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {

        HbaseTest hbaseTest = new HbaseTest();
        // hbaseTest.droptable();
        // hbaseTest.createtab();
        // hbaseTest.putdata();
        // hbaseTest.getdata();
        // testpool(hbaseTest);
        // getpagedata(hbaseTest);
        counter(hbaseTest);
    }

    /**
     *
     * @Title: counter
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年11月22日 上午11:47:53
     * @param hbaseTest
     */
    private static void counter(HbaseTest hbaseTest) {
        hbaseTest.counter();
    }

    /**
     *
     * @Title: counter
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年11月22日 上午11:48:07
     */
    private void counter() {
        try {
            Table table = this.getConnection().getTable(TableName.valueOf("counters"));
            System.out.println(table.incrementColumnValue("rk1".getBytes(), "cf1".getBytes(), "count".getBytes(), 1));
            Result result = table.get(new Get("rk1".getBytes()));
            for (Cell cell : result.listCells()) {
                System.out
                        .println(Bytes.toString(cell.getFamilyArray(), cell.getFamilyOffset(), cell.getFamilyLength()));
                System.out.println(
                        Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength()));
                System.out.println(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
            }
            table.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @Title: getpagedata
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年11月22日 上午11:13:08
     * @param hbaseTest
     */
    private static void getpagedata(HbaseTest hbaseTest) {
        hbaseTest.getpagedata();
    }

    /**
     *
     * @Title: getpagedata
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年11月22日 上午11:13:54
     */
    private void getpagedata() {
        try {
            Table table = this.getConnection().getTable(TableName.valueOf("test_snappy2"));
            PageFilter pageFilter = new PageFilter(10);
            int totalrows = 0;
            byte[] lastrow = "1479783482796".getBytes();
            Scan scan = new Scan();
            scan.setFilter(pageFilter);
            /*
             * if (null != lastrow) {
             * byte[] startrow = lastrow;
             * Bytes.toStringBinary(startrow);
             * scan.setStartRow(startrow);
             * }
             */
            ResultScanner scanner = table.getScanner(scan);
            int localrows = 0;
            Result result;
            while ((result = scanner.next()) != null) {
                System.out.println(localrows++ + ":" + result);
                totalrows++;
                lastrow = result.getRow();
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @Title: testpool
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年11月22日 上午10:30:27
     */
    private static void testpool(final HbaseTest hbaseTest) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                public void run() {
                    hbaseTest.putdata();
                }
            }).start();
        }
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
            Table table = this.getConnection().getTable(TableName.valueOf("test_snappy2"));
            Get get = new Get("a".getBytes());
            // byte[][] colkey = KeyValue.parseColumn(Bytes.toBytes("colfamly:val1"));
            Result result = table.get(get);
            if (null != result) {
                List<Cell> data = result.listCells();
                for (Cell cell : data) {
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
     * @param i
     * @date 2016年11月21日 下午2:56:24
     */
    private void putdata() {
        for (int i = 0; i < 100; i++) {
            long s = System.currentTimeMillis();
            Connection connection = null;
            Table table = null;
            try {
                connection = this.getConnection();
                table = connection.getTable(TableName.valueOf("test_snappy2"));
                Put put = new Put(Bytes.toBytes(System.currentTimeMillis() + ""));
                put.addColumn("colfam".getBytes(), "val1".getBytes(), "colfam1".getBytes());
                table.put(put);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != table) {
                        table.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (null != connection) {
                        connection.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ",cost:" + (System.currentTimeMillis() - s));
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
