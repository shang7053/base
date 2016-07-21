/**   
 *
 * @Title: ForkTask.java 
 * @Package threadtest 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年5月16日 下午3:05:01   
 */
package threadtest;

import java.util.concurrent.RecursiveTask;

/**
 *
 * @ClassName: ForkTask
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年5月16日 下午3:05:01
 * 
 */
public class ForkTask extends RecursiveTask<Integer> {

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
     * @date 2016年5月16日 下午3:05:01
     */
    public ForkTask() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (非 Javadoc)
     * <p>Title: compute</p>
     * <p>Description: </p>
     * 
     * @return
     * 
     * @see java.util.concurrent.RecursiveTask#compute()
     */
    @Override
    protected Integer compute() {
        System.out.println("ForkTask.compute()");
        return 1;
    }

}
