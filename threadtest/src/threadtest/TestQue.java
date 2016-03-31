/**
 * @Title: TestQue.java 
 * @Package test 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author shangchengcai@voole.com
 * @date 2016年3月31日 下午4:18:07   
 */
package threadtest;

import java.util.ArrayDeque;

/**
 * @ClassName: TestQue
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author shangchengcai@voole.com
 * @date 2016年3月31日 下午4:18:07
 * 
 */
public class TestQue {
    public static void main(String[] args) {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("1");
        arrayDeque.add("2");
        arrayDeque.add("3");
        arrayDeque.add("4");
        arrayDeque.add("5");
        printDeque(arrayDeque);
        // arrayDeque.push("6");
        // printDeque(arrayDeque);
        System.out.println(arrayDeque.pop());
        printDeque(arrayDeque);
    }

    /**
     * @Title: printDeque
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author shangchengcai@voole.com
     * @param arrayDeque
     * @date 2016年3月31日 下午4:19:53
     */
    private static void printDeque(ArrayDeque<String> arrayDeque) {
        System.out.println("----------------------------------");
        for (String string : arrayDeque) {
            System.out.println(string);
        }
        System.out.println("----------------------------------");

    }
}
