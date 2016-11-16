/**   
 *
 * @Title: ZookeeperTest.java 
 * @Package scc.zookeeper 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年11月16日 下午4:14:42   
 */
package scc.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.AsyncCallback.StringCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 *
 * @ClassName: ZookeeperTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年11月16日 下午4:14:42
 * 
 */
public class ZookeeperTest {

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("10.5.3.100:2181,10.5.3.101:2181,10.5.3.102:2181", 5000, null);
        System.out.println(zooKeeper.getState());
        // create(zooKeeper);
        // createsync(zooKeeper);
        // delete(zooKeeper);
        // get(zooKeeper);
        // update(zooKeeper);
        exists(zooKeeper);
    }

    /**
     *
     * @Title: exists
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年11月16日 下午4:37:21
     * @param zooKeeper
     * @throws InterruptedException
     * @throws KeeperException
     */
    private static void exists(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        // TODO Auto-generated method stub
        System.out.println(zooKeeper.exists("/test", false));
    }

    /**
     *
     * @Title: update
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年11月16日 下午4:35:16
     * @param zooKeeper
     * @throws InterruptedException
     * @throws KeeperException
     */
    private static void update(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        // TODO Auto-generated method stub
        zooKeeper.setData("/zk-test-sync", "sadasd".getBytes(), -1);
    }

    /**
     *
     * @Title: get
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年11月16日 下午4:31:54
     * @param zooKeeper
     * @throws InterruptedException
     * @throws KeeperException
     */
    private static void get(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        System.out.println(zooKeeper.getChildren("/zk-test-sync", false));
        System.out.println(new String(zooKeeper.getData("/zk-test-sync", false, new Stat())));
    }

    /**
     *
     * @Title: delete
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年11月16日 下午4:27:49
     * @param zooKeeper
     * @throws KeeperException
     * @throws InterruptedException
     */
    private static void delete(ZooKeeper zooKeeper) throws InterruptedException, KeeperException {
        zooKeeper.delete("/zk-test", -1);
    }

    /**
     *
     * @Title: createsync
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年11月16日 下午4:24:11
     * @param zooKeeper
     * @throws InterruptedException
     */
    private static void createsync(ZooKeeper zooKeeper) throws InterruptedException {
        zooKeeper.create("/zk-test-sync", "1234".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT,
                new StringCallback() {
                    public void processResult(int rc, String path, Object ctx, String name) {
                        System.out.println(rc + ":" + path + ":" + ctx + ":" + name);
                    }
                }, "haha");
        Thread.sleep(1000000);
    }

    /**
     *
     * @Title: create
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年11月16日 下午4:17:53
     * @param zooKeeper
     * @throws InterruptedException
     * @throws KeeperException
     */
    private static void create(ZooKeeper zooKeeper) throws KeeperException, InterruptedException {
        System.out.println(zooKeeper.create("/zk-test", "1234".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT));
    }

}
