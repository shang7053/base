/**   
 *
 * @Title: IMyInterface.java 
 * @Package java8.study 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年3月31日 下午4:44:09   
 */
package java8.study;

/**
 *
 * @ClassName: IMyInterface
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年3月31日 下午4:44:09
 * 
 */
public interface IMyInterface {
    void test();

    void test2(String aa);

    default void test3() {
        System.out.println("this is methodBody of interface!");
    }
}
