/**   
 *
 * @Title: Fork.java 
 * @Package threadtest 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年5月16日 下午3:04:40   
 */
package threadtest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 *
 * @ClassName: Fork
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年5月16日 下午3:04:40
 * 
 */
public class Fork {

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
     * @date 2016年5月16日 下午3:04:40
     */
    public Fork() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ForkTask t1 = new ForkTask();
        ForkTask2 t2 = new ForkTask2();
        t1.fork();
        t2.fork();
        System.out.println(t1.join() + t2.join());

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask ret = pool.submit(t1);
        System.out.println(ret.get());
    }
}
