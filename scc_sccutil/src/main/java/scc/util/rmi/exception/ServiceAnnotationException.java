package scc.util.rmi.exception;
/**
 * 
 * @ClassName: ServiceAnnotationException 
 * @Description: 接口注解为标注异常
 * @author scc
 * @date 2014年12月25日 上午10:20:10 
 *
 */
public class ServiceAnnotationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3632990516912528533L;

	public ServiceAnnotationException(Class<?> c) {
		super("接口【"+c+"】上没有找到@Scc标签");
	}

}
