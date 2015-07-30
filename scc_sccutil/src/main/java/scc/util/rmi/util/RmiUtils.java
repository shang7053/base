package scc.util.rmi.util;

import java.net.InetAddress;
import java.rmi.server.RemoteServer;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @ClassName: RmiUtils 
 * @Description: 获取远程客户端主机ip
 * @author 
 * @date 2014年12月25日 上午10:18:36 
 *
 */
public final class RmiUtils {
	//static final List<String> errorIp = new ArrayList<String>();
	/**
	 * 获取RMI客户端主机
	 * @return
	 */
	public static String getClientIp(){
		try {
			InetAddress ia = java.net.InetAddress.getByName(RemoteServer.getClientHost());
			return ia.getHostAddress();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
