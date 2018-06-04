package scc.util.rmi.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 
 * @ClassName: Scc 
 * @Description: 接口注解，指定实现类的包名加类名
 * @author scc
 * @date 2014年12月25日 上午10:16:42 
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Scc {
	String impl();
}
