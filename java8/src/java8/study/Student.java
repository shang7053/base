/**   
 *
 * @Title: Student.java 
 * @Package java8.study 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年4月1日 上午10:39:54   
 */
package java8.study;

/**
 *
 * @ClassName: Student
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年4月1日 上午10:39:54
 * 
 */
public class Student {
    private int age;
    private String name;

    public int getAge() {
        return this.age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public static void main(String[] args) {
        new Student().setAge(1).setName("s");
    }
}
