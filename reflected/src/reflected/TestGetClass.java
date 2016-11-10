/**   
 *
 * @Title: TestGetClass.java 
 * @Package reflected 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author scc
 * @date 2016年11月7日 上午11:28:17   
 */
package reflected;

/**
 *
 * @ClassName: TestGetClass
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author scc
 * @date 2016年11月7日 上午11:28:17
 * 
 */
public class TestGetClass {

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
     * @date 2016年11月7日 上午11:28:17
     */
    public TestGetClass() {

    }

    public static void main(String[] args) throws NoSuchFieldException, SecurityException {
        System.out.println(getSuperClassGenricType());
    }

    public static Class<?> getSuperClassGenricType() throws NoSuchFieldException, SecurityException {

        return TypeArgFinder.getFieldClassGenricType(User.class.getDeclaredField("users"));
        // // 返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。
        // Type genType = clazz.getGenericSuperclass();
        //
        // if (!(genType instanceof ParameterizedType)) {
        // return Object.class;
        // }
        // // 返回表示此类型实际类型参数的 Type 对象的数组。
        // Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        //
        // if (index >= params.length || index < 0) {
        // return Object.class;
        // }
        // if (!(params[index] instanceof Class)) {
        // return Object.class;
        // }
        //
        // return (Class) params[index];
    }
}
