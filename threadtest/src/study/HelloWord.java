/**   
 *
 * @Title: HelloWord.java 
 * @Package study 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年5月17日 上午11:18:48   
 */
package study;

/**
 *
 * @ClassName: HelloWord
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年5月17日 上午11:18:48
 * 
 */
public class HelloWord {
    public static int i = 100;
    private static final int L = 100;

    public String sayHello() {
        this.add(i, L);
        return "hello word!";
    }

    public int add(int i, int l) {
        return i + l;

    }

    public static void main(String[] args) {
        System.out.println(new HelloWord().sayHello());
    }
}
