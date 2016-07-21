/**   
 *
 * @Title: Test.java 
 * @Package study 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年5月16日 下午3:54:02   
 */
package study;

import java.io.IOException;

/**
 *
 * @ClassName: Test
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年5月16日 下午3:54:02
 * 
 */
public class Test {

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
     * @date 2016年5月16日 下午3:54:02
     */
    public Test() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) throws IOException {
        // int i = 0;
        // for (;;) {
        // String.valueOf(i).intern();
        // i++;
        // }
        // Object a = new Object();
        // a = null;
        // System.out.println("ss");
        // for (int i = 0; i < 10000; i++) {
        // new String("s");
        // }
        // System.gc();
        Subject s = new Subject();
        s.addObserver(new Watcher());
        s.notifyObservers();
        s.notifyObservers("sass");
    }
}
