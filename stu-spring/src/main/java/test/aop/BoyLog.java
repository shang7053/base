/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月2日 下午5:07:16
*/
package test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <p>Description: </p>
 * @author scc
 * @since 创建时间：2015年11月2日 下午5:07:16
 */
@Aspect
@Component
public class BoyLog {
	/**
	 * <p>Description: </p>
	 * @author scc
	 * @since 创建时间：2015年11月2日 下午5:08:18
	 ********************************** 
	 */
	@Pointcut("execution(* *.say(..))")
	public void say() {
		// TODO Auto-generated constructor stub
	}
	@Before("say()")
	public void before(){
		System.out.println("BoyLog.before()");
	}
	@After("say()")
	public void after(){
		System.out.println("BoyLog.after()");
	}
	@AfterReturning("say()")
	public void afterreturn(){
		System.out.println("BoyLog.afterreturn()");
	}
	@Around("say()")
	public void around(ProceedingJoinPoint joinPoint){
		System.out.println("BoyLog.around()");
		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("BoyLog.around()");
	}
}
