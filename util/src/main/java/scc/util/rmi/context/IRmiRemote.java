package scc.util.rmi.context;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * 远程实现接口
 * @author scc
 *
 */
interface IRmiRemote extends Remote{
	/**
	 * 执行远程方法
	 * @param rmi 远程数据
	 * @return
	 * @throws RemoteException
	 */
	public Object invoke(RmiRemote rmi) throws RemoteException;
}
