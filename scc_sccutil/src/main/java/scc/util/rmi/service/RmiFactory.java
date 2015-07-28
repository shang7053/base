package scc.util.rmi.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import scc.util.rmi.annotation.Scc;
import scc.util.rmi.exception.ServiceAnnotationException;


/**
 * service实例化工厂
 * @author scc
 */
public abstract class RmiFactory {
	private final static RmiFactory mf = new BaseManagerFactory();
	/**
	 * 实例化Manager
	 * @param c
	 * @return
	 */
	public static <T> T instance(Class<T> c){
		return mf.instanceService(c);
	}
	/**
	 * 实例化Manager
	 * @param c
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T instanceService(Class<T> c){
		return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class<?>[]{c}, getInvocationHandler(c));
	}
	/**
	 * 获得切面代理
	 * @return
	 */
	protected abstract InvocationHandler getInvocationHandler(Class<?> c);
	//=============================================================
	static final class BaseManagerFactory extends RmiFactory{

		@Override
		protected InvocationHandler getInvocationHandler(Class<?> c) {
			return new BaseInvocationHandler(c);
		}
	}
	//=============================================================
	final class BaseInvocationHandler implements InvocationHandler{
		private Class<?> c;
		BaseInvocationHandler(Class<?> c){
			this.c=c;
		}
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			Scc annotation = c.getAnnotation(Scc.class);
			if(null == annotation){
				throw new ServiceAnnotationException(c);
			}
			String impl = annotation.impl();
			Class<?> ci = Class.forName(impl, false, Thread.currentThread().getContextClassLoader());
			Object obj = ci.newInstance();
			try{
				Object result = method.invoke(obj, args);
				return result;
			}catch(Throwable e){
				throw e;
			}
		}
	}
}
