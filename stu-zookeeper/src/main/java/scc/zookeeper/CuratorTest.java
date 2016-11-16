/**   
 *
 * @Title: CuratorTest.java 
 * @Package scc.zookeeper 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年11月16日 下午4:41:02   
 */
package scc.zookeeper;

import com.netflix.curator.RetryPolicy;
import com.netflix.curator.framework.CuratorFramework;
import com.netflix.curator.framework.CuratorFrameworkFactory;
import com.netflix.curator.retry.ExponentialBackoffRetry;

/**
 *
 * @ClassName: CuratorTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年11月16日 下午4:41:02
 * 
 */
public class CuratorTest {

    public static void main(String[] args) throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework curatorFramework = CuratorFrameworkFactory
                .newClient("10.5.3.100:2181,10.5.3.101:2181,10.5.3.102:2181", retryPolicy);
        System.out.println(curatorFramework.getState());
        curatorFramework.start();
        System.out.println(curatorFramework.getState());
        System.out.println("创建");
        System.out.println(curatorFramework.create().forPath("/cur-test", "haha".getBytes()));
        System.out.println("查询");
        System.out.println(new String(curatorFramework.getData().forPath("/cur-test")));
        System.out.println("修改");
        System.out.println(curatorFramework.setData().forPath("/cur-test", "sds".getBytes()));
        System.out.println("删除");
        curatorFramework.delete().forPath("/cur-test");
        curatorFramework.close();
    }

}
