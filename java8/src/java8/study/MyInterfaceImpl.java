/**   
 *
 * @Title: MyInterfaceImpl.java 
 * @Package java8.study 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年3月31日 下午4:48:04   
 */
package java8.study;

/**
 *
 * @ClassName: MyInterfaceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年3月31日 下午4:48:04
 * 
 */
public class MyInterfaceImpl implements IMyInterface {

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
     * @date 2016年3月31日 下午4:48:04
     */
    public MyInterfaceImpl() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (非 Javadoc)
     * <p>Title: test</p>
     * <p>Description: </p>
     * 
     * @see java8.study.IMyInterface#test()
     */
    @Override
    public void test() {
        this.test3();
    }

    /*
     * (非 Javadoc)
     * <p>Title: test2</p>
     * <p>Description: </p>
     * 
     * @param aa
     * 
     * @see java8.study.IMyInterface#test2(java.lang.String)
     */
    @Override
    public void test2(String aa) {
        this.test3();
    }

    public static void main(String[] args) {
        new MyInterfaceImpl().test();
    }

}
