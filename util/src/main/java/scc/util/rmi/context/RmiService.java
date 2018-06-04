package scc.util.rmi.context;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import scc.util.SccUtilFactory;
import scc.util.propeties.service.IProperties;
import scc.util.rmi.exception.RmiException;


/**
 * 
 * @ClassName: RmiService
 * @Description: 服务端调用，启动rmi
 * @author scc
 * @date 2014年12月25日 上午10:21:24
 *
 */
public final class RmiService {
	private static String ip;
	private static int port;
	static {
		IProperties properties=SccUtilFactory.instanceProperties();
		String sip= properties.readValue("sccrmi.properties", "ip");
		if(null==sip||"".equals(sip)){
			try {
				throw new RmiException("未配置ip");
			} catch (RmiException e) {
				e.printStackTrace();
			}
		}
		ip =sip;
		String sport=properties.readValue("sccrmi.properties", "port");
		try {
			throw new RmiException("未配置端口");
		} catch (RmiException e) {
			e.printStackTrace();
		}
		port = Integer.valueOf(sport);
	}

	private RmiService() {
	}

	public static void openRmi() throws RemoteException {
		Registry r;
		System.setProperty("java.rmi.server.hostname", ip);
		LocateRegistry.createRegistry(port);
		r = LocateRegistry.getRegistry(ip, port);
		r.rebind(IRmiRemote.class.getName(), new RmiRemoteImpl());
	}
}
