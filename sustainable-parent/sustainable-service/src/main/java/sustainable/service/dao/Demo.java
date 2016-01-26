/**   
* @Title: Demo.java 
* @Package sustainable.service.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author scc
* @date 2016年1月26日 上午10:18:15   
*/
package sustainable.service.dao;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * @ClassName: Demo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年1月26日 上午10:18:15
 * 
 */
public class Demo {

    /**
     * <p>
     * Title:
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @author scc
     * @date 2016年1月26日 上午10:18:15
     */
    public Demo() {
        // TODO Auto-generated constructor stub
    }

    // 会话超时时间，设置为与系统默认时间一致
    private static final int SESSION_TIMEOUT = 30000;
    // 创建Zookeeper实例
    ZooKeeper zk;
    // 创建Watcher实例
    Watcher wh = new Watcher() {
        @Override
        public void process(WatchedEvent event) {
            System.out.println(event.toString());
        }
    };

    public void createZKInstance() throws IOException {
        this.zk = new ZooKeeper("172.16.60.31:2181", Demo.SESSION_TIMEOUT, this.wh);
    }

    private void ZKOperations() throws Exception, InterruptedException {
        System.out.println("/n1. 创建 ZooKeeper 节点 (znode ： zoo2, 数据： myData2 ，权限：OPEN_ACL_UNSAFE ，节点类型： Persistent");
        this.zk.create("/zoo2", "myData2".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("/n2. 查看是否创建成功： ");
        System.out.println(new String(this.zk.getData("/zoo2", false, null)));
        System.out.println("/n3. 修改节点数据 ");
        this.zk.setData("/zoo2", "shenlan211314".getBytes(), -1);
        System.out.println("/n4. 查看是否修改成功： ");
        System.out.println(new String(this.zk.getData("/zoo2", false, null)));
        System.out.println("/n5. 删除节点 ");
        this.zk.delete("/zoo2", -1);
        System.out.println("/n6. 查看节点是否被删除： ");
        System.out.println(" 节点状态： [" + this.zk.exists("/zoo2", false) + "]");
    }

    private void ZKClose() throws InterruptedException {
        this.zk.close();
    }

    public static void main(String[] args) throws Exception {
        Demo dm = new Demo();
        dm.createZKInstance();
        dm.ZKOperations();
        dm.ZKClose();
    }
}
