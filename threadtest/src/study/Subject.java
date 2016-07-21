/**   
 *
 * @Title: Subject.java 
 * @Package study 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年5月18日 下午1:20:09   
 */
package study;

import java.util.Observable;

/**
 *
 * @ClassName: Subject
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年5月18日 下午1:20:09
 * 
 */
public class Subject extends Observable {

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
     * @date 2016年5月18日 下午1:20:09
     */
    public Subject() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (非 Javadoc)
     * <p>Title: notifyObservers</p>
     * <p>Description: </p>
     * 
     * @see java.util.Observable#notifyObservers()
     */
    @Override
    public void notifyObservers() {
        // TODO Auto-generated method stub
        super.setChanged();
        super.notifyObservers();
    }

    /*
     * (非 Javadoc)
     * <p>Title: notifyObservers</p>
     * <p>Description: </p>
     * 
     * @param arg
     * 
     * @see java.util.Observable#notifyObservers(java.lang.Object)
     */
    @Override
    public void notifyObservers(Object arg) {
        // TODO Auto-generated method stub
        super.setChanged();
        super.notifyObservers(arg);
    }
}
