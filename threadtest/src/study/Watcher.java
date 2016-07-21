/**   
 *
 * @Title: Watcher.java 
 * @Package study 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年5月18日 下午1:22:21   
 */
package study;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @ClassName: Watcher
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年5月18日 下午1:22:21
 * 
 */
public class Watcher implements Observer {

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
     * @date 2016年5月18日 下午1:22:21
     */
    public Watcher() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (非 Javadoc)
     * <p>Title: update</p>
     * <p>Description: </p>
     * 
     * @param o
     * 
     * @param arg
     * 
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        System.out.println(arg);
    }

}
