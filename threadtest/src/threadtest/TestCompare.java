/**   
 *
 * @Title: TestCompare.java 
 * @Package threadtest 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年2月24日 下午4:55:05   
 */
package threadtest;

/**
 *
 * @ClassName: TestCompare
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年2月24日 下午4:55:05
 * 
 */
public class TestCompare {

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
     * @date 2016年2月24日 下午4:55:06
     */
    public TestCompare() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        System.out.println(1 == 1);
        Integer a = 1;
        Integer b = 1;
        System.out.println(a == b);
        Integer aa = -127;
        Integer bb = -127;
        System.out.println(aa == bb);
        System.out.println(aa.equals(bb));
        Integer aaa = new Integer(1);
        Integer bbb = new Integer(1);
        System.out.println(aaa.equals(bbb));
        // Collections.synchronizedList(list)
    }
}
