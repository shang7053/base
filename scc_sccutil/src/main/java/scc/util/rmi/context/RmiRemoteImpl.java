package scc.util.rmi.context;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.apache.log4j.Logger;

import scc.util.rmi.service.RmiFactory;


class RmiRemoteImpl extends UnicastRemoteObject implements IRmiRemote{
	private Logger logger=Logger.getLogger(RmiRemoteImpl.class);

	public RmiRemoteImpl() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7911662448169271887L;
	@Override
	public Object invoke(RmiRemote rmi) throws RemoteException {
		try {
			String mc = rmi.getManagerClass();
			Class<?> c = Class.forName(mc, false, Thread.currentThread().getContextClassLoader());
			Object i = RmiFactory.instance(c);
			Method[] ms = i.getClass().getDeclaredMethods();
			for(Method m : ms){
				if(m.getName().equals(rmi.getMethod())){
					if(m.getParameterTypes().length == rmi.getArgs().length){
						try {
							return m.invoke(i, rmi.getArgs());
						} catch (IllegalArgumentException e) {
							continue;
						} catch (IllegalAccessException e) {
							continue;
						} catch (InvocationTargetException e) {
							continue;
						}
					}
				}
			}
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		return null;
	}
	public static Method getMethod(Class<?> implClass,String methodName,Class<?>...params) throws SecurityException, NoSuchMethodException{
		if(null == params || 0 == params.length){
			return implClass.getMethod(methodName);
		}
		//20130813
		Method cacheMethod = null;
		try {
			cacheMethod = implClass.getDeclaredMethod(methodName, params);
		} catch (Exception e) {
		}
		if(null != cacheMethod){
			return cacheMethod;
		}
		//
		Method[] ms = implClass.getMethods();
		L1:for(Method m : ms){
			if(!m.getName().equals(methodName)){
				continue;
			}
			Class<?>[] types = m.getParameterTypes();
			if(null == types || 0==types.length || types.length != params.length){
				continue;
			}
			for(int i=0; i<types.length; i++){
				Class<?> p = params[i];
				Class<?> t = types[i];
				if(!equals(p,t)){
					continue L1;
				}
			}
			return m;
		}
		//20130813
		L1:for(Method m : ms){
			if(!m.getName().equals(methodName)){
				continue;
			}
			Class<?>[] types = m.getParameterTypes();
			if(null == types || 0==types.length || types.length != params.length){
				continue;
			}
			for(int i=0; i<types.length; i++){
				Class<?> p = params[i];
				Class<?> t = types[i];
				if(!equals1(p,t)){
					continue L1;
				}
			}
			return m;
		}
		//
		return null;
	}
	private static boolean equals1(Class<?> p, Class<?> t) {
		if(p.equals(t)){
			return true;
		}else if(p.equals(Integer.class)){
			return t.equals(int.class);
		}else if(p.equals(Long.class)){
			return t.equals(long.class);
		}else if(p.equals(Float.class)){
			return t.equals(float.class);
		}else if(p.equals(Double.class)){
			return t.equals(double.class);
		}else if(p.equals(Byte.class)){
			return t.equals(byte.class);
		}else if(p.equals(Short.class)){
			return t.equals(short.class);
		}else if(p.equals(Character.class)){
			return t.equals(char.class);
		}else if(p.equals(Boolean.class)){
			return t.equals(boolean.class);
		}else{
			return t.isAssignableFrom(p);
		}
//		return false;
	}
	private static boolean equals(Class<?> p, Class<?> t) {
		if(p.equals(t)){
			return true;
		}else if(p.equals(Integer.class)){
			return t.equals(int.class);
		}else if(p.equals(Long.class)){
			return t.equals(long.class);
		}else if(p.equals(Float.class)){
			return t.equals(float.class);
		}else if(p.equals(Double.class)){
			return t.equals(double.class);
		}else if(p.equals(Byte.class)){
			return t.equals(byte.class);
		}else if(p.equals(Short.class)){
			return t.equals(short.class);
		}else if(p.equals(Character.class)){
			return t.equals(char.class);
		}else if(p.equals(Boolean.class)){
			return t.equals(boolean.class);
		}
		return false;
	}
}
