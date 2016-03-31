/**   
 *
 * @Title: Lambda.java 
 * @Package java8.study 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年3月31日 下午4:49:22   
 */
package java8.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 *
 * @ClassName: Lambda
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年3月31日 下午4:49:22
 * 
 */
public class Lambda {

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
     * @date 2016年3月31日 下午4:49:22
     */
    public Lambda() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        // sort();
        list();
    }

    /**
     *
     * @Title: list
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年3月31日 下午5:22:57
     */
    private static void list() {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        // stringCollection.add("ccc");
        // stringCollection.add("bbb2");
        // stringCollection.add("ddd1");
        // stringCollection.stream().filter((s) -> s.startsWith("a")).forEach((s) -> System.out.println(s));
        // stringCollection.stream().map((s) -> s + "1").forEach(System.out::println);
        Optional<String> o = stringCollection.stream().map((s) -> {
            System.out.println(s);
            return s + "1";
        }).reduce((a, b) -> {
            System.out.println("a:" + a);
            System.out.println("b:" + b);
            return a + b;
        });
        System.out.println(o.orElseGet(() -> "0"));
        // .forEach(System.out::println);
    }

    /**
     *
     * @Title: sort
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author scc
     * @date 2016年3月31日 下午4:50:00
     */
    private static void sort() {
        Thread t = new Thread(() -> System.out.println("haha"));
        Collections.sort(new ArrayList<String>(), (String a, String b) -> {
            return b.compareTo(a);
        });
        Collections.sort(new ArrayList<String>(), (a, b) -> b.compareTo(a));

    }
}
