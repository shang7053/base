package scc.util.rmi.context;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import scc.util.SccUtilFactory;
import scc.util.propeties.service.IProperties;
import scc.util.rmi.exception.RmiException;
import scc.util.rmi.service.RmiFactory;

/**
 * 
 * @ClassName: RemoteServiceFactory 
 * @Description: rmi核心实现工厂
 * @author scc
 * @date 2014年12月25日 上午10:20:38 
 *
 */
public class RemoteServiceFactory extends RmiFactory{
	
	private final static RMIDirectSocketFactory rmiFactory = new RMIDirectSocketFactory();
	private final static RemoteServiceFactory mf = new RemoteServiceFactory();
	private static String remoteIp;
	private static Integer remotePort;
	static {
		IProperties properties=SccUtilFactory.instanceProperties();
		String sip= properties.readValue("sccrmi.properties", "ip");
		if(null==sip||"".equals(sip)){
			try {
				throw new RmiException("未配置ip");
			} catch (RmiException e) {
				e.printStackTrace();
			}
			remoteIp =sip;
		}
		String sport=properties.readValue("sccrmi.properties", "port");
		try {
			throw new RmiException("未配置端口");
		} catch (RmiException e) {
			e.printStackTrace();
		}
		remotePort = Integer.valueOf(sport);
	}
	private RemoteServiceFactory(){
	}
	/**
	 * 实例化Manager
	 * @param c
	 * @return
	 */
	public static <T> T instance(Class<T> c){
		return mf.instanceService(c);
	}
	/*public static void setRemoteIp(String remoteIp) {
		mf.remoteIp = remoteIp;
	}
	public static void setRemotePort(int remotePort) {
		mf.remotePort = remotePort;
	}*/
	//=============================================================
	protected InvocationHandler getInvocationHandler(Class<?> c) {
		return new RemoteBaseInvocationHandler(c);
	}

	//=============================================================
	static final class RemoteBaseInvocationHandler implements InvocationHandler{
		private Class<?> c;
		RemoteBaseInvocationHandler(Class<?> c){
			this.c=c;
		}
		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			String ip = remoteIp;//==null?"127.0.0.1":f.remoteIp;
			int port = remotePort;//==null?9700:f.remotePort;
			Registry r = LocateRegistry.getRegistry(ip, port, rmiFactory);
			Remote remote = r.lookup(IRmiRemote.class.getName());
			if(remote instanceof IRmiRemote){
				IRmiRemote mf = (IRmiRemote)remote;
				RmiRemote rmi = new RmiRemote();
				rmi.setManagerClass(c.getName());
				rmi.setMethod(method.getName());
				rmi.setArgs(null==args?new Object[0]:args);
				try {
					return mf.invoke(rmi);
				} catch (Throwable e) {
					if(e instanceof RmiException){
						int code = ((RmiException) e).getCode();
						switch (code) {
						case RmiException.RMI_RequestIP_Error:
							break;
						case RmiException.RMI_AboveMaxConn_Error:
							break;
						default:
							break;
						}
					}
					throw e;
				}
			}
			throw new RemoteException("未能找到远程代理对象，请检查是否注册远程代理，远程地址或端口是否正确");
		}
	}
}
